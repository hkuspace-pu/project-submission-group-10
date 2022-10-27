package com.springboot.responseFormat;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.springboot.dao.RespondFormatDTO;

/**
 * respond返回的格式
 * */

@Component
public class ReturnFormat {
	
	public String respondFormatJsonStr(
			int code, 
			String msg, 
			String zhMsg,
			Object data,
			int num,
			int page,
			int total
			) {
		
		RespondFormatDTO respondFormat = new RespondFormatDTO();
		
		respondFormat.setCode(code);
		respondFormat.setMsg(msg);
		respondFormat.setZhMsg(zhMsg);
		respondFormat.setNum(num);
		respondFormat.setPageSize(page);
		respondFormat.setTotal(total);
		respondFormat.setData(data);
		
		
		return JSON.toJSONString(respondFormat);
		
	}
	
}
