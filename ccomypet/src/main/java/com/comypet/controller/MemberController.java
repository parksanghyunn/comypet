package com.comypet.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comypet.domain.Criteria;
import com.comypet.domain.MemberVO;
import com.comypet.domain.PageDTO;
import com.comypet.service.MemberService;
import com.comypet.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/member/*")
public class MemberController {
	private MemberService service;
	//@Inject
	private JavaMailSender mailSender;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberVO member, HttpSession session, RedirectAttributes rttr) throws Exception{
		Utils util = new Utils();
		/*String re_pw = Utils.encrySHA256(member.getMember_pw());
		member.setMember_pw(re_pw);*/
		String s_id = service.login(member);
		if(s_id != null) {
			int member_uid = service.getMemberUid(s_id);
			String member_nick = service.getMemberNick(member_uid);
			session.setAttribute("session_id", s_id);
			session.setAttribute("session_uid", member_uid);
			session.setAttribute("session_nick", member_nick);
			session.setAttribute("session_profile", service.myProfil(member_uid));
			return"redirect:/index";
		}else {
			rttr.addFlashAttribute("result", "no");
		}
		return"redirect:/member/login";
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		
		return "/index";
	}
	
	@GetMapping("/ToS")
	public void ToS() {}
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberVO member){
		System.out.println("join.............");
		Utils utile = new Utils();
		String re_pw = utile.encrySHA256(member.getMember_pw());
		member.setMember_pw(re_pw);
		
		if(service.join(member)) {
			return "redirect:/member/joinOk";
		}
		return "redirect:/member/join";
	}
	
	@GetMapping("/joinOk")
	public void joinOk() {}
	
	@RequestMapping(value = "/check_id/{member_id}", method= RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> check_id(@PathVariable String member_id){
		System.out.println(member_id);
		if(service.checkid(member_id)==0) {
			System.out.println("ok");
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}else {
			System.out.println("no");
			return new ResponseEntity<>("no", HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/check_nick/{member_nick}", method= RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> check_nick(@PathVariable String member_nick){
		System.out.println(member_nick);
		System.out.println(service.checkNick(member_nick));
		if(service.checkNick(member_nick)==0) {
			System.out.println("ok");
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}else {
			System.out.println("no");
			return new ResponseEntity<>("no", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/check_email", method= RequestMethod.POST, produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> check_email(@RequestParam("member_email") String member_email){
		System.out.println(member_email);
		if(service.checkEmail(member_email)==0) {
			System.out.println("ok");
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}else {
			System.out.println("no");
			return new ResponseEntity<>("no", HttpStatus.OK);
		}
	}
	 // mailSending 코드
    @RequestMapping( value = "/send_email", method=RequestMethod.POST,produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> mailSending(@RequestParam String member_email) throws IOException {
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        
        String setfrom = "jsap50@naver.com";
        String tomail = member_email; // 받는 사람 이메일
        String title = "회원가입 인증 이메일 입니다."; // 제목
        String content = 
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 comypet을 찾아주셔서 감사합니다"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해주세요"; // 내용
        
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
            return new ResponseEntity<>(dice+"", HttpStatus.OK);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/myPage")
    public void myPage(@RequestParam("board_state") int board_state,Criteria cri,HttpSession session,Model model) {
    	String board_name = "";
		switch (board_state) {
		case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 10:
			board_name = "cs";
			break;
		default:
			break;
		}
		int member_uid = (int) session.getAttribute("session_uid");
		System.out.println(service.myBoard(cri, board_name, member_uid));
    	model.addAttribute("list", service.myBoard(cri, board_name, member_uid));
    	model.addAttribute("pageMaker", new PageDTO(cri, service.myBoardTotal(board_name, member_uid)));
    	model.addAttribute("board_state", board_state);
	}
    
    
    @RequestMapping(value ="/myInfo/{member_uid}",method = RequestMethod.GET)
    public String myInfo(@PathVariable int member_uid, Model model) {
    	MemberVO member = service.myInfo(member_uid);
    	model.addAttribute("member", member);
    	System.out.println(member);
    	return "/member/myInfo";
    }
    
    @PostMapping("/infoUpdate")
    public String infoUpdate(MemberVO member, HttpSession session,RedirectAttributes rttr) {
    	if(service.updateInfo(member)) {
    		rttr.addFlashAttribute("result", "success");
    		session.setAttribute("session_nick", member.getMember_nick());
    	}
    	return "redirect:/member/myInfo/"+member.getMember_uid();
    }
    
    @GetMapping("/deleteMyBoard")
    public String deleteMyBoatd(@RequestParam("board_idx") int board_idx, @RequestParam("board_state") int board_state,Criteria cri,RedirectAttributes rttr) {
    	String board_name = "";
    	switch (board_state) {
    	case 1:
			board_name = "free";
			break;
		case 2:
			board_name = "meet";
			break;
		case 3:
			board_name = "fra";
			break;
		case 4:
			board_name = "qna";
			break;
		case 10:
			board_name = "cs";
			break;
		}
    	
    	if(service.deleteMyBoard(board_name, board_idx)) {
    		rttr.addFlashAttribute("result", "success");
    	}
    	return "redirect:/member/myPage"+cri.getListLink()+"&board_state="+board_state;
    }
    
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam(value = "file_name", required=false) MultipartFile mf,HttpSession session, RedirectAttributes rttr) {
    	int member_uid = (int)session.getAttribute("session_uid");
 //   	String folder = "C:/psh_java/workspace_sp이관/ccomypet/src/main/webapp/resources/images/member/profile/"+member_uid;
    	String folder = session.getServletContext().getRealPath("resources/images/member/profile/"+member_uid);
    	File file = new File(folder);
    	if(!file.isDirectory()) {
    		file.mkdirs();
    		System.out.println("폴더 생성");
    	}
    	String file_name = mf.getOriginalFilename();
    	//Long file_size = mf.getSize();
    	String saveFile = folder+"\\"+file_name;
    	System.out.println(saveFile);
    	  try {
              mf.transferTo(new File(saveFile));
              if(service.updateProfile(file_name, member_uid)) {
            	  session.setAttribute("session_profile",service.myProfil(member_uid));
            	  rttr.addFlashAttribute("resulte", "upProfile");
              }
             } catch (IllegalStateException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
    	  return "redirect:/member/myInfo/"+member_uid;
    }
    
    @GetMapping("/deleteProfile")
    public String deleteProfil(HttpSession session,RedirectAttributes rttr) {
    	int member_uid = (int)session.getAttribute("session_uid");
    	if(service.deleteProfile(member_uid)) {
    		session.setAttribute("session_profile",service.myProfil(member_uid));
    		rttr.addFlashAttribute("result", "delProfile");
    	}
    	return "redirect:/member/myInfo/"+member_uid;
    }
}
