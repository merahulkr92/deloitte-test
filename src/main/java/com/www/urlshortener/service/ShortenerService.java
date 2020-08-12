package com.www.urlshortener.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.www.urlshortener.domain.Redirection;
import com.www.urlshortener.domain.ShortenUrl;
import com.www.urlshortener.domain.SourceInfo;
import com.www.urlshortener.exception.UnknownUrlException;
import com.www.urlshortener.repository.RedirectionRepository;
import com.www.urlshortener.repository.ShortenerRepository;

import java.util.Map;
import java.util.Optional;

@Component
public class ShortenerService {

	static Logger log = LoggerFactory.getLogger(ShortenerService.class);

	@Autowired
	private ShortenerRepository shortenerRepository;

	@Autowired
	private RedirectionRepository redirectionRepository;

	@Autowired
	private CodeService codeService;

	public ShortenUrl shorten(String url) {
		ShortenUrl shortenUrl = new ShortenUrl(url);
		shortenUrl.shorten(codeService, shortenerRepository);
		return shortenUrl;
	}

	public String getRedirectionUrl(String code, Map<String, String> requestInfo) {
		final Optional<ShortenUrl> shortenUrl = shortenerRepository.findByCode(code);

		if (!shortenUrl.isPresent())
			throw new UnknownUrlException();

		shortenUrl.get().increaseHits();
		redirectionRepository.save(new Redirection(shortenUrl.get(), new SourceInfo(requestInfo)));

		log.info("Redirecting code[" + code + "] url[" + shortenUrl.get().getUrl() + "]");

		return shortenUrl.get().getUrl();
	}
}
