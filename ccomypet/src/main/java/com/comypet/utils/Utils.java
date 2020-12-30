package com.comypet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	
	public static String encrySHA256(String str) {
		String sha = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<byteData.length;i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			sha = sb.toString();
		}catch(NoSuchAlgorithmException e) {
			System.out.println("Utils.encry error");
			sha = null;
		}
		return sha;
	}
	
	//세션에 저장되 있는 멤버 고유 값 가져오기
	public static int getUid(HttpServletRequest request) {
		int uid = (int)request.getSession().getAttribute("session_uid");
		return uid;
	}
	
	//파일 복사 
    public static void copys(File selectFile, File copyFile) throws IOException { //복사할 디렉토리, 복사될 디렉토리
    	FileInputStream fis = null;
    	FileOutputStream fos = null;

    	try {
    		fis = new FileInputStream(selectFile);                             // 원본파일
    		fos = new FileOutputStream(copyFile+"/");   // 복사위치

    		byte[] buffer = new byte[1024];
    		int readcount = 0;

    		while((readcount=fis.read(buffer)) != -1) {
    			fos.write(buffer, 0, readcount);    // 파일 복사 
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		fis.close();
    		fos.close();
    	}
    }
    
    public static void Move(String inFileName, String outFileName){
    	System.out.println(inFileName+"파일이 잇는경로");
    	System.out.println(outFileName+"이동할 경로");
        byte[] buf = new byte[1024];
        FileInputStream fin = null;
        FileOutputStream fout = null;
        
        File file = new File(inFileName);
        if(!file.renameTo(new File(outFileName))){    // renameTo로 이동 실패할 경우

        	buf = new byte[1024];
        	try {
        		fin = new FileInputStream(inFileName);
        		fout = new FileOutputStream(outFileName);
        		int read = 0;
        		while((read=fin.read(buf,0,buf.length))!=-1){
        			fout.write(buf, 0, read);
        		}

        		fin.close();
        		fout.close();
        		file.delete();                        // 복사 후 파일 삭제
        	} catch (IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        } 
    }

	//폴더 삭제
	 public static boolean delete(String path) {
		 boolean check = false;
		 
		 File folder = new File(path);
		 try {
			 if(folder.exists()){
				 File[] folder_list = folder.listFiles();

				 for (int i = 0; i < folder_list.length; i++) {
					 if(folder_list[i].isFile()) {
						 folder_list[i].delete();
					 }else {
						 delete(folder_list[i].getPath());
					 }
					 folder_list[i].delete();
				 }
				 folder.delete();
				 check = true;
			 }
		 } catch (Exception e) {
			 e.getStackTrace();
		 }
		 return check;
	 }
	 
	 public static boolean deleteFile(String path) {
		 boolean check = false;
		 
		 File folder = new File(path);
		 try {
			 if(folder.exists()){
				folder.delete();
				check = true;
			 }else {
				 System.out.println("파일이 존재하지 않습니다.");
			 }
		 } catch (Exception e) {
			 e.getStackTrace();
		 }
		 return check;
	 }
}