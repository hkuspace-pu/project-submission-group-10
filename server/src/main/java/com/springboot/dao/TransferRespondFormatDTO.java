package com.springboot.dao;

import java.util.List;

import lombok.Data;

@Data
public class TransferRespondFormatDTO {

	private int errorNo;
	private String errMsg;
	private String errZhMsg;
	private List<?> data;
	
}
