package com.www.urlshortener.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.www.urlshortener.domain.ShortenUrl;
import com.www.urlshortener.request.ShortenRequest;
import com.www.urlshortener.response.ShortenResponse;
import com.www.urlshortener.service.ShortenerApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shortener")
public class UrlShortenerController {

	final static Logger log = LoggerFactory.getLogger(UrlShortenerController.class);

	@Autowired
	private ShortenerApplicationService shortenerApplicationService;

	@PostMapping("/")
	public ShortenResponse shorten(@RequestBody ShortenRequest request) throws IOException {
		return shortenerApplicationService.shorten(request.getUrl());
	}

	@GetMapping("/shorten-urls")
	public List<ShortenUrl> listShortenUrls() {
		return shortenerApplicationService.listShortenUrls();
	}

	@GetMapping("/{code}")
	public void redirect(@PathVariable String code, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect(shortenerApplicationService.getRedirectionUrl(code, getSourceInfoMap(request)));
	}

	private Map<String, String> getSourceInfoMap(HttpServletRequest request) {
		Map<String, String> sourceInfo = new HashMap<>();
		sourceInfo.put("userAgent", request.getHeader("User-Agent"));
		sourceInfo.put("sourceHost", request.getHeader("Host"));
		sourceInfo.put("sourceRequestDate", request.getHeader("Date"));
		return sourceInfo;
	}
}