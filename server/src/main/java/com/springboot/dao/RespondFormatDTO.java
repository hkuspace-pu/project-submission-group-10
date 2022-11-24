package com.springboot.dao;

import lombok.Data;

@Data
public class RespondFormatDTO {

	private int code;
	private String msg;
	private String zhMsg;
	private Object data;
	private int total;
	private int num;
	private int pageSize;
	
}
