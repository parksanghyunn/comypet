package com.comypet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comypet.domain.Criteria;
import com.comypet.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTests {
	@Setter(onMethod_= @Autowired)
	private MemberService service;
	
/*	@Test
	public void testCheckEmail() {
		if(service.checkEmail("jsap50@naver.com")==0) {
			log.info("ok..............");
		}else {
			log.info("no..............");
		}
	}*/
	
	/*@Test
	public void testMyBoard() {
		log.info(service.myBoard(new Criteria(1,10), "FREE", 4));
	}*/

	/*@Test
	public void testInfo() {
		log.info(service.myInfo(4));
	}*/
	/*
	@Test
	public void testJoin() {
		MemberVO member = new MemberVO();
		String from = "2013-04-08 10:10:10";

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date to = transFormat.parse(from);
			member.setMember_id("qazdfsfddf");
			member.setMember_pw("1111");
			member.setMember_name("그");
			member.setMember_nick("asd");
			member.setMember_email("asd@asd.asd");
			member.setMember_birth(to);
			member.setMember_tel("010-0101-0101");
			member.setMember_gender("남");
			member.setMember_zipcode("111-11");
			member.setMember_address("ads");
			member.setMember_address_detail("asdD");
			member.setMember_address_etc("101호");
			service.join(member);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*@Test
	public void testPro() {
		log.info(service.myProfil(4));
	}*/
}
