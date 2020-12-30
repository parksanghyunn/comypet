package com.comypet.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comypet.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	/*@Test
	public void testInsert() {
		MemberVo member = new MemberVo();
		String from = "2013-04-08 10:10:10";

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date to = transFormat.parse(from);

		member.setMember_id("qaz");
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
		
		log.info("insert..... : "+ mapper.insertMemberJoin(member));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}*/
	
	@Test
	public void testInfo() {
		log.info(mapper.selectInfo(4));
	}
	
/*	@Test
	public void testBoardCnt() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("board_name", "FREE");
		map.put("member_uid", 4);
		log.info(mapper.selectMyBoardCnt(map));
	}*/
	
/*	@Test
	public void testMyBoard() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("board_name", "FREE");
		map.put("pageNum", 1);
		map.put("amount", 10);
		map.put("member_uid", 4);
		log.info(mapper.selectMyBoard(map));
	}*/
}
