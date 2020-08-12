package com.www.urlshortener.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.urlshortener.domain.ShortenUrl;
import com.www.urlshortener.repository.ShortenerRepository;
import com.www.urlshortener.response.ShortenResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShortenerApplicationService {

	static Logger log = LoggerFactory.getLogger(ShortenerApplicationService.class);

	@Autowired
	private ShortenerService shortenerService;

	@Autowired
	private ShortenerRepository shortenerRepository;

	public ShortenResponse shorten(String url) {
		ShortenUrl shortenUrl = shortenerService.shorten(url);
		return new ShortenResponse(shortenUrl.getId(), shortenUrl.getCode(), shortenUrl.getCreationDate(), true, null);
	}

	public String getRedirectionUrl(String code, Map<String, String> requestInfo) {
		return shortenerService.getRedirectionUrl(code, requestInfo);
	}

	public List<ShortenUrl> listShortenUrls() {
		return shortenerRepository.findAll();
	}
}
