package com.comypet.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.sql.DATE;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //Servlet의 ServletContext를 이용하기 위함
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class MemberControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext wac;
	
	//가짜 MVC
	//마치 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있다.
	private MockMvc mockMvc;
	
	@Before	//@Before가 적용된 메소드는 모든 테스트 전에 매번 실행된다.
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
/*	@Test
	public void testCheckEmail() throws Exception{
		log.info("email............."+mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/member/check_email")
				.param("member_email","jsap50@naver.com"))
				.andReturn().getModelAndView().getModelMap());
	}*/
	
	/*@Test
	public void testMyBoard() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/member/myPage").content("1")).andReturn().getModelAndView().getModelMap());
	}*/
	
/*	@Test
	public void testInfo() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/member/myInfo").content("4"))
				.andReturn().getModelAndView().getModelMap());
	}*/
	
/*	@Test
	public void testJoin() throws Exception{
		 log.info(mockMvc.perform(MockMvcRequestBuilders.post("/member/join")
				.param("member_id", "asdasdasdasdasdasdasd")
				.param("member_pw", "1111")
				.param("member_name", "ㅁㄴㅇ")
				.param("member_nick", "sdf")
				.param("member_email", "sdf")
				.param("member_gender", "sd")
				.param("member_birth", "2002-20-20")
				.param("member_tel", "1111")
				.param("member_zipcode", "1111")
				.param("member_address", "1111")
				.param("member_address_detail", "1111")
				.param("member_address_etc", "1111")
				).andReturn().getModelAndView().getViewName());
	}*/
/*	@Test
	public void testLogin() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/member/login")
				.param("member_id", "asd")
				.param("member_pw", "1111")
				).andReturn().getModelAndView().getModelMap());
	}*/
}
