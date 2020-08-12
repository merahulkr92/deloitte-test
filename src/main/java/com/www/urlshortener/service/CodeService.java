package com.www.urlshortener.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CodeService {

	final static Logger log = LoggerFactory.getLogger(CodeService.class);

	public String nextCode(long seed) {
		return Long.toHexString(seed);
	}
}
