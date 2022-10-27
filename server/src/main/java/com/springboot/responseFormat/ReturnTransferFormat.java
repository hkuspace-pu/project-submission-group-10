package com.springboot.responseFormat;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.springboot.dao.TransferRespondFormatDTO;


@Component
public class ReturnTransferFormat {

	public String respondTransferFormat(
			int code, 
			String msg, 
			String zhMsg,
			List<?> data
			) {
		
		TransferRespondFormatDTO transferRespondFormatDTO = new TransferRespondFormatDTO();
		transferRespondFormatDTO.setErrorNo(code);
		transferRespondFormatDTO.setErrMsg(msg);
		transferRespondFormatDTO.setErrZhMsg(zhMsg);
		transferRespondFormatDTO.setData(data);
		
		return JSON.toJSONString(transferRespondFormatDTO);		
		
	}
	
}
