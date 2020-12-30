package com.comypet.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

//Criteria : 검색의 기준
@Data
public class Criteria {
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum  = pageNum;
		this.amount = amount;
	}
	
	
	//쿼리 스트링을 만들어줌
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum",this.pageNum)
				.queryParam("amount",this.amount);
		
		return builder.toUriString();
				
	}
}







