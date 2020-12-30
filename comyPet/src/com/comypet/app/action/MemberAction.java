package com.comypet.app.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.comypet.action.Action;
import com.comypet.action.ActionForward;
import com.comypet.app.dao.BoardDao;
import com.comypet.app.dao.BoardFilesDao;
import com.comypet.app.dao.MemberDao;
import com.comypet.app.vo.BoardReportVo;
import com.comypet.app.vo.BoardViewVo;
import com.comypet.app.vo.MemberReportVo;
import com.comypet.app.vo.MemberVo;
import com.comypet.utils.Utils;
import com.naver.api.ApiExamSearchBlog;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, String type)throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		switch(type) {
		case "MemberCheckEmailNumAction":
			forward = MemberCheckEmailNumAction(request, response);
			return forward;
		case "MemberCheckIdOkAction":
			forward = MemberCheckIdOkAction(request, response);
			return forward;
		case "MemberCheckNickOkAction":
			forward = MemberCheckNickOkAction(request, response);
			return forward;
		case "MemberFindIdOkAction":
			forward = MemberFindIdOkAction(request, response);
			return forward;
		case "MemberJoinOkAction":
			forward = MemberJoinOkAction(request, response);
			return forward;
		case "MemberLoginOkAction":
			forward = MemberLoginOkAction(request, response);
			return forward;
		case "MemberLogOutAction":
			forward = MemberLogOutAction(request, response);
			return forward;
		case "MemberSendEmailOkAction":
			forward = MemberSendEmailOkAction(request, response);
			return forward;
		case "MemberSelectInfoOkAction":
			forward = MemberSelectInfoOkAction(request, response);
			return forward;
		case "MemberUpdateInfoOkAction":
			forward = MemberUpdateInfoOkAction(request, response);
			return forward;
		case "MemberUpdatePwOkAction":
			forward = MemberUpdatePwOkAction(request, response);
			return forward;
		case "MemberDeleteProfileOkAction":
			forward = MemberDeleteProfileOkAction(request, response);
			return forward;
		case "MemberUpdateProfileOkAction":
			forward = MemberUpdateProfileOkAction(request, response);
			return forward;
		case "MemberSendIdOkAction":
			forward = MemberSendIdOkAction(request, response);
			return forward;
		case "MemberFindPwOkAction":
			forward = MemberFindPwOkAction(request, response);
			return forward;
		case "MemberMyBoardOkAction":
			forward = MemberMyBoardOkAction(request, response);
			return forward;
		case "MemberDeleteMyBoardOkAction":
			forward = MemberDeleteMyBoardOkAction(request, response);
			return forward;
		case "MemberBoardReportReasonOkAction":
			forward = MemberBoardReportReasonOkAction(request, response);
			return forward;
		case "MemberReportOkAction":
			forward = MemberReportOkAction(request, response);
			return forward;
		case "returnNewsList":
			forward = ReturnNewsList(request, response);
			break;
		case "selectIndexList":
		forward = selectIndexList(request, response);
		return forward;
		}

		return null;
	}
	
	public ActionForward selectIndexList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ActionForward forward = new ActionForward();
		
		BoardDao boardDao = new BoardDao();
		List<Map<String,Object>> boardDogList = boardDao.selectIndexxGalleryDogList();
		List<Map<String,Object>> boardCatList = boardDao.selectIndexxGalleryCatList();
		List<Map<String,Object>> boardEtcList = boardDao.selectIndexxGalleryEtcList();
		List<Map<String,Object>> boardFindList = boardDao.selectIndexxGalleryFindList();
		List<BoardViewVo> boardFreeList = boardDao.selectIndexxFreeBoardList();
		List<BoardViewVo> boardMeetList = boardDao.selectIndexxMeetBoardList();
		List<BoardViewVo> boardFraList = boardDao.selectIndexxFraBoardList();
		
		request.setAttribute("boardDogList", boardDogList);
		request.setAttribute("boardCatList", boardCatList);
		request.setAttribute("boardEtcList", boardEtcList);
		request.setAttribute("boardFindList", boardFindList);
		request.setAttribute("boardFreeList", boardFreeList);
		request.setAttribute("boardMeetList", boardMeetList);
		request.setAttribute("boardFraList", boardFraList);
		
		forward.setRedirect(false);
		forward.setPath("/app/index.jsp");
		return forward;
	}

	public ActionForward MemberCheckEmailNumAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		HttpSession session = request.getSession();

		String session_num = (String)session.getAttribute("session_num");

		PrintWriter out = response.getWriter();

		response.setContentType("text/html;charset=utf-8");
		if(num.equals(session_num)) {
			out.println("ok");
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}

	public ActionForward MemberCheckIdOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		MemberDao memberDao = new MemberDao();
		String id =  request.getParameter("id");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		if(!memberDao.idCheck(id)) {
			out.println("ok");
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}

	public ActionForward MemberCheckNickOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		MemberDao memberDao = new MemberDao();
		String nick =  request.getParameter("nick");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		if(!memberDao.nickCheck(nick)) {
			out.println("ok");
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}

	public ActionForward MemberFindIdOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		MemberDao memberDao = new MemberDao();

		System.out.println("입력한 이름 : " + request.getParameter("member_name"));
		System.out.println("입력한 이메일 : " + request.getParameter("member_email"));
		String name = request.getParameter("member_name");
		String email = request.getParameter("member_email");
		String s_id = memberDao.findId(name,email);

		if(s_id != null) {
			String d_id = s_id.substring(0,s_id.length()-2) + "**";
			session.setAttribute("send_id", s_id);
			session.setAttribute("display_id", d_id);
			session.setAttribute("send_email", email);
			forward.setRedirect(true);
			forward.setPath("/app/member/findIdOk.jsp");

		}else {
			forward.setRedirect(false);
			forward.setPath("/MemberFindId.me?findId=false");
		}
		return forward;
	}

	public ActionForward MemberJoinOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();

		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = new MemberVo();
		Utils security = new Utils();
		//비밀번호 암호화
		String member_pw = security.encrySHA256(request.getParameter("member_pw"));
		
		SimpleDateFormat birth = new SimpleDateFormat("yyyy-mm-dd");
		Date birthh = birth.parse(request.getParameter("member_birth"));
		
		memberVo.setMember_name(request.getParameter("member_name"));
		memberVo.setMember_id(request.getParameter("member_id"));
		memberVo.setMember_pw(member_pw);
		memberVo.setMember_nick(request.getParameter("member_nick"));
		memberVo.setMember_gender(request.getParameter("member_gender"));
		memberVo.setMember_birth(birthh);
		memberVo.setMember_tel(request.getParameter("member_tel"));
		memberVo.setMember_email(request.getParameter("member_email"));
		memberVo.setMember_zipcode(request.getParameter("member_zipcode"));
		memberVo.setMember_address(request.getParameter("member_address"));
		memberVo.setMember_address_detail(request.getParameter("member_address_detail"));
		memberVo.setMember_address_etc(request.getParameter("member_address_etc"));

		if(!memberDao.join(memberVo)) {
			forward.setRedirect(false);
			forward.setPath("/MemberJoin.me?join=false");
		}else {
			System.out.println("회원가입 완료");
			memberDao.insertProfile();
			forward.setRedirect(false);
			forward.setPath("/app/member/joinOk.jsp");
		}
		return forward;
	}

	public ActionForward MemberLogOutAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		//session.setAttribute("session_uid", "null");
		session.invalidate();
		forward.setRedirect(true);
		forward.setPath("/Index.me");
		return forward;
	}

	public ActionForward MemberSendEmailOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");

		
		HttpSession session = request.getSession();
		
		MemberDao memberDao = new MemberDao();
		
		if(memberDao.selectEmailCheck(email)) {
			System.out.println("중복이메일임asdasz");
			request.setAttribute("email_check", 1);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.println("no");
		}else {
			
		// mail server 설정
		// 메일을 어느 계정으로 보낼지 설정해준다.
		String host = "smtp.naver.com"; //host를 설정해준다.
		String user = "jsap50@naver.com"; // 메일을 보낼 네이버 계정의 아이디를 입력해준다.
		String password = "@jsapsj5060@";// 메일을 보낼 네이버 계정의 패스워드를 입력해준다.

		// 메일 받을 주소를 받아와 to_email에 담아준다.
		String to_email = email;

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		// 인증 번호 생성기 (random을 통해 난수를 생성한다.)
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 7; i++) {
			// 0-9
			temp.append(rnd.nextInt(10));
		}
		String AuthenticationKey = temp.toString();
		System.out.println(AuthenticationKey);

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		// email 전송
		try {
			MimeMessage msg = new MimeMessage(session1);
			msg.setFrom(new InternetAddress(user, "COMYPET"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

			// 메일 제목
			msg.setSubject("인증번호가 도착했습니다.");
			// 메일 내용
			msg.setText("인증번호 :" + temp+"\n인증번호를 확인해주세요!");

			Transport.send(msg);
			System.out.println("이메일 전송");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.println(AuthenticationKey);
			session.setAttribute("session_num", AuthenticationKey);
			System.out.println(session.getAttribute("session_num"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward MemberSelectInfoOkAction (HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = new MemberVo();
		HttpSession session = request.getSession();

		int member_uid = (Integer)session.getAttribute("session_uid");
		memberVo = memberDao.selectInfo(member_uid);
		if(memberVo != null) {
			request.setAttribute("member_id", memberVo.getMember_id());
			request.setAttribute("member_nick", memberVo.getMember_nick());
			request.setAttribute("member_name", memberVo.getMember_name());
			request.setAttribute("member_email", memberVo.getMember_email());
			request.setAttribute("member_tel", memberVo.getMember_tel());
			request.setAttribute("member_gender", memberVo.getMember_gender());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String birth = date.format(memberVo.getMember_birth()); 
			request.setAttribute("member_birth",birth);
			request.setAttribute("member_zipcode", memberVo.getMember_zipcode());
			request.setAttribute("member_address", memberVo.getMember_address());
			request.setAttribute("member_address_detail", memberVo.getMember_address_detail());
			request.setAttribute("member_address_etc", memberVo.getMember_address_etc());
		}
		forward.setRedirect(false);
		forward.setPath("/MemberInfo.me");
		return forward;
	}

	public ActionForward MemberLoginOkAction (HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		MemberDao memberDao = new MemberDao();

		Utils security = new Utils();
		
		
		String id = request.getParameter("member_id");
		String pw = security.encrySHA256(request.getParameter("member_pw"));
		String s_id = memberDao.login(id, pw);

		if(s_id != null) {
			session.setAttribute("session_id", s_id);
			session.setAttribute("session_uid", memberDao.memberGetUid(id));
			session.setAttribute("session_nick", memberDao.getNick(memberDao.memberGetUid(id)));
			session.setAttribute("session_profile", memberDao.selectProfile(memberDao.memberGetUid(id)));
			session.setAttribute("checkCnt", 0);
			//글쓰기와 댓글 달기가 제한된 유저라면 alert으로 제한된 유저라고 알려주기.(정지된 유저라면 1 리턴, 아니면 0리턴)
			if(memberDao.muteCheck(memberDao.memberGetUid(id))) {
				//경고창
				session.setAttribute("muteCheck", 1);

			}else {
				session.setAttribute("muteCheck", 0);
				
			}
			forward.setRedirect(true);
			forward.setPath("/Index.me");
		}else {
			forward.setRedirect(false);

			forward.setPath("/app/member/login.jsp?login=false");
		}
		return forward;
	}

	public ActionForward MemberUpdateInfoOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		HashMap<String, Object> member_map = new HashMap<>();

		int member_uid = (Integer)session.getAttribute("session_uid");
		String member_nick = request.getParameter("member_nick");
		String member_tel = request.getParameter("member_tel");
		String member_zipcode = request.getParameter("member_zipcode");
		String member_address = request.getParameter("member_address");
		String member_address_detail = request.getParameter("member_address_detail");
		String member_address_etc = request.getParameter("member_address_etc");
		member_map.put("member_uid", (int)member_uid);
		member_map.put("member_nick", (String)member_nick);
		member_map.put("member_tel", (String)member_tel);
		member_map.put("member_zipcode", (String)member_zipcode);
		member_map.put("member_address", (String)member_address);
		member_map.put("member_address_detail", (String)member_address_detail);
		member_map.put("member_address_etc", (String)member_address_etc);

		System.out.println(member_map.get("member_uid"));
		memberDao.updateInfo(member_map);
		session.setAttribute("session_nick", member_nick);
		forward.setRedirect(false);
		forward.setPath("/MemberSelectInfoOk.me");
		return forward;

	}
	
	public ActionForward MemberUpdatePwOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		Utils security = new Utils();
		
		String member_id = (String)session.getAttribute("session_id");
		String member_now_pw = security.encrySHA256(request.getParameter("member_pw"));
		String member_change_pw = request.getParameter("member_change_pw");
		String member_change_pw_re = request.getParameter("member_change_pw_re");
		
		if(memberDao.selectEqualsNowPw(member_id, member_now_pw)) {
			if(member_change_pw.equals(member_change_pw_re)) {
				String member_pw = security.encrySHA256(member_change_pw);
				memberDao.updatePw(member_id, member_pw);
				//alert으로 변경 완료! 해주면서 그 어디야 마이페이지로 이동
				forward.setRedirect(true);
				forward.setPath("/MemberMyBoardOk.me?change=true&board_state=0");
			}else {
				forward.setRedirect(false);
				forward.setPath("/app/member/updatePw.jsp?reason=change");
			}
		}else {
			forward.setRedirect(false);
			forward.setPath("/app/member/updatePw.jsp?reason=now");
			
		}
		
		//일단 공백 확인하고 > 현재 비밀번호 맞는지 확인하고 > 그 다음에 변경할 비밀번호가 맞는지 확인하고 > 그 다음에 DB에 접근해서 update해주기
		//일단 입력한 현재 비밀번호와 DB에 저장된 현재 비밀번호를 비교한다. 
		
		//맞으면 
		return forward;
	}

	private ActionForward MemberDeleteProfileOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		int member_uid = (Integer)session.getAttribute("session_uid");
		memberDao.deleteProfile(member_uid);
		session.setAttribute("session_profile", "defaultProfile.png");
		forward.setRedirect(false);
		forward.setPath("/MemberSelectInfoOk.me");
		return forward;
	}

	private ActionForward MemberUpdateProfileOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		//ProfileVo profileVo = new ProfileVo();
		HttpSession session = request.getSession();

		int member_uid = (Integer)session.getAttribute("session_uid");
		String filePathServer = session.getServletContext().getRealPath("app/upload/profile/"+member_uid);
		File folder = new File(filePathServer);

		if (!folder.isDirectory()) {
			try{
				folder.mkdir(); //폴더 생성합니다.
				System.out.println("폴더가 생성되었습니다.");
			} 
			catch(Exception e){
				e.getStackTrace();
			}        
		}else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		int fileSize = 5 * 1024 * 1024; //5M
		MultipartRequest multi = null;
		multi = new MultipartRequest(request, filePathServer, fileSize, "UTF-8", new DefaultFileRenamePolicy());


		String member_profile = memberDao.updateProfile(member_uid,multi);
		if(member_profile!=null) {
			session.setAttribute("session_profile", member_profile);
			forward.setRedirect(true);
			forward.setPath(request.getContextPath()+"/MemberSelectInfoOk.me");
			return forward;
		}
		return null;

	}
	public ActionForward MemberSendIdOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		//아이디를 보낼 이메일을 세션에서 가져와서 저장한다.
		String email = (String)session.getAttribute("send_email");

		//이메일에 보낼 아이디를 세션에서 가져와서 저장한다.
		String id = (String)session.getAttribute("send_id");
		System.out.println("email : " + email);
		System.out.println("세션이메일 : " + session.getAttribute("email"));
		System.out.println("세션 아이디: " + session.getAttribute("send_id"));
		// mail server 설정
		// 메일을 어느 계정으로 보낼지 설정해준다.
		String host = "smtp.naver.com"; //host를 설정해준다.
		String user = "jsap50@naver.com"; // 메일을 보낼 네이버 계정의 아이디를 입력해준다.
		String password = "@jsapsj5060@";// 메일을 보낼 네이버 계정의 패스워드를 입력해준다.

		// 메일 받을 주소를 받아와 to_email에 담아준다.
		String to_email = email;

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		// 인증 번호 생성기 (random을 통해 난수를 생성한다.)

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		// email 전송
		try {
			MimeMessage msg = new MimeMessage(session1);
			msg.setFrom(new InternetAddress(user, "COMYPET"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

			// 메일 제목
			msg.setSubject("아이디가 전송되었습니다.");
			// 메일 내용
			msg.setText("아이디 : " + id +"\n아이디를 확인해주세요!");

			Transport.send(msg);
			System.out.println("이메일 전송");
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//아이디, 이메일이 같으면 들어와서 비밀번호를 랜덤으로 변경 후 이메일에 보내주고 세션에 저장.
	public void MemberSendPwOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		//아이디를 보낼 이메일을 세션에서 가져와서 저장한다.
		String email = (String)session.getAttribute("send_email");

		//이메일에 보낼 아이디를 세션에서 가져와서 저장한다.
		System.out.println("email : " + email);
		System.out.println("세션이메일 : " + session.getAttribute("send_email"));
		// mail server 설정
		// 메일을 어느 계정으로 보낼지 설정해준다.
		String host = "smtp.naver.com"; //host를 설정해준다.
		String user = "jsap50@naver.com"; // 메일을 보낼 네이버 계정의 아이디를 입력해준다.
		String password = "@jsapsj5060@";// 메일을 보낼 네이버 계정의 패스워드를 입력해준다.

		// 메일 받을 주소를 받아와 to_email에 담아준다.
		String to_email = email;

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		// 인증 번호 생성기 (random을 통해 난수를 생성한다.)
		char pwCollection[] = new char[] {
				'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'!','@','#','$','%','^','&','*','(',')'};

		String changePw = "";

		for (int i = 0; i < 10; i++) {
			int selectRandomPw = (int)(Math.random()*(pwCollection.length));//Math.rondom()은 0.0이상 1.0미만의 난수를 생성해 준다.
			changePw += pwCollection[selectRandomPw];
		}

		System.out.println("임시 비밀번호 : " + changePw);

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		// email 전송
		try {
			MimeMessage msg = new MimeMessage(session1);
			msg.setFrom(new InternetAddress(user, "COMYPET"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

			// 메일 제목
			msg.setSubject("비밀번호가 전송되었습니다.");
			// 메일 내용
			msg.setText("비밀번호 : " + changePw +"\n비밀번호를 확인해주세요!" + "\n빠른 기간 내에 비밀번호를 변경해주시기 바랍니다.");

			Transport.send(msg);
			System.out.println("이메일 전송");
			response.setContentType("text/html;charset=utf-8");
			session.setAttribute("change_pw", changePw);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public ActionForward MemberFindPwOkAction(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		MemberDao m_dao = new MemberDao();
		String id = request.getParameter("member_id");
		String email = request.getParameter("member_email");

		session.setAttribute("send_email", email);


		if(m_dao.findPw(id, email)) {
			//일치하는 값이 있으면 여기서 변경된 비밀번호 이메일에 전송 후 비밀번호 변경하기
			MemberSendPwOkAction(request, response);
			String change_pw = (String)session.getAttribute("change_pw");
			String re_change_pw = Utils.encrySHA256(change_pw);
			m_dao.updatePw(id,re_change_pw);

			session.invalidate();
			forward.setRedirect(false);
			forward.setPath("/app/member/findPwOk.jsp");
		} else {
			//아니면 경고창

			System.out.println("비밀번호 찾기 실패");

			forward.setRedirect(false);
			forward.setPath("/app/member/findPw.jsp?findPw=false");
		}
		return forward;
	}
	public ActionForward MemberMyBoardOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MemberDao memberDao = new MemberDao();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		int member_uid = (Integer)session.getAttribute("session_uid");
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		String temp = request.getParameter("page");
		board_state = board_state == 0 ? 1 : Integer.parseInt(request.getParameter("board_state"));
		String board_name= "";
		switch (board_state) {
		case 0:board_name = "notice";break;
		case 1:board_name = "free";break;
		case 2:board_name = "meet";break;
		case 3:board_name = "fra";break;
		case 4:board_name = "qna";break;
		case 5:board_name = "puppy";break;
		case 6:board_name = "cat";break;
		case 7:board_name = "detail";break;
		case 8:board_name = "etc";break;
		case 9:board_name = "lost";break;
		case 10:board_name = "sug";break;
		}
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		int pageSize = 10;
		int endRow = page * pageSize;
		int startRow = endRow - (pageSize - 1);
		int totalCnt = 0;
		int startPage = 0;
		int endPage = 0;
		int totalPage = 0;
		
		totalCnt = memberDao.selectMyBoardCnt(member_uid,board_name);
		startPage = ((page - 1) / pageSize) * pageSize + 1;
		endPage = startPage + 9;
		totalPage = (totalCnt - 1) / pageSize + 1;
		endPage = endPage > totalPage ? totalPage : endPage;
		request.setAttribute("boardList", memberDao.selectMyBoard(startRow, endRow, member_uid,board_name));
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("board_state", board_state);
		
		forward.setRedirect(false);
		forward.setPath("/MemberMyPage.me");
		return forward;
	}
	public ActionForward MemberDeleteMyBoardOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int board_state = Integer.parseInt(request.getParameter("board_state"));
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		BoardFilesDao boardFilesDao = new BoardFilesDao();
		String board_name = "";
		
		switch (board_state) {
		case 0:board_name = "notice";break;
		case 1:board_name = "free";break;
		case 2:board_name = "meet";break;
		case 3:board_name = "fra";break;
		case 4:board_name = "qna";break;
		case 5:board_name = "puppy";break;
		case 6:board_name = "cat";break;
		case 7:board_name = "detail";break;
		case 8:board_name = "etc";break;
		case 9:board_name = "lost";break;
		case 10:board_name = "sug";break;
		}
		
		String pathh = request.getSession().getServletContext().getRealPath("");
		String path = boardFilesDao.selectBoardPath(board_idx);
		
		if(path != null) {
			path = path.substring(0,path.lastIndexOf("\\"));
			File file = new File(pathh+path);
			File[] list = file.listFiles();
			if(file.isDirectory()) {
				for(int i=0;i<list.length;i++) {
					list[i].delete();
				}
			}
		}
		
		boardFilesDao.deleteInsertFiles(board_idx);
		memberDao.deleteMyBoard(board_idx, board_name);
		//String folder = "C:\\psh_java\\workspace\\comyPet\\WebContent\\resource\\images\\board\\"+boardTitle;
		//Utils.delete(folder);
		forward.setRedirect(false);
		forward.setPath("/MemberMyBoardOk.me");
		return forward;
	}
	public ActionForward MemberBoardReportReasonOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int board_idx = Integer.parseInt(request.getParameter("board_idx"));
		ActionForward forward = new ActionForward();
		MemberDao memberDao = new MemberDao();
		
		List<BoardReportVo> boardReportList = memberDao.selectReportReason(board_idx);
		if(boardReportList !=null) {
			
		request.setAttribute("boardReportList", boardReportList);
		
		forward.setRedirect(false);
		forward.setPath("/MemberBoardReportReason.me");
		return forward;
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset='UTF-8'");
			out.println("<script>");
			out.println("alert('신고내역이 존재하지 않습니다.');");
			out.println("self.close();");
			out.println("</script>");
			out.close();
			return null;
		}
	}
	public ActionForward MemberReportOkAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		MemberDao memberDao = new MemberDao();
		MemberReportVo memberReportVo = new MemberReportVo();
		HttpSession session = request.getSession();
		
		int writer = Integer.parseInt(request.getParameter("writer"));
		String report_type = request.getParameter("report_type");
		int reporter = (int) session.getAttribute("session_uid");
		
		memberReportVo.setReport_type(report_type);
		memberReportVo.setReporter(reporter);
		memberReportVo.setWriter(writer);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		if(memberDao.insertMemberReport(memberReportVo)) {
			out.println("ok");
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}
	
	private ActionForward ReturnNewsList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		String data = ApiExamSearchBlog.getNews();
		String sendData = data.substring(data.indexOf("[")+1, data.lastIndexOf("]"));
		String[] realData = sendData.split("},");
		JSONObject obj = new JSONObject();
		ArrayList<Object> arrayList = new ArrayList<>();
		
		for(int i=0;i<realData.length;i++) {
			if(i==9) {
				arrayList.add(i, realData[i]);
			}else {
				arrayList.add(i, realData[i]+"}");
			}
		}
		
		String title = "";
		String link = "";
		
		HashMap<String, Object> map = new HashMap<>();
		
		for(int i=0;i<arrayList.size();i++) {
			title = arrayList.get(i).toString().substring(arrayList.get(i).toString().indexOf("title\": \"")+9, arrayList.get(i).toString().indexOf("\",\""));
			link = arrayList.get(i).toString().substring(arrayList.get(i).toString().indexOf("originallink\": ")+16, arrayList.get(i).toString().indexOf("\",\"link\""));
			map.put("title", title);
			map.put("link", link);
			obj.put(i, map);
			map = new HashMap<>();
		}
		
		PrintWriter out = response.getWriter();
		out.print(obj.toJSONString());
		out.close();
		
		return null;
	}
}



