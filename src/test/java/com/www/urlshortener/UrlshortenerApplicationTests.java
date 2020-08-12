package com.www.urlshortener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.www.urlshortener.exception.ShortenerException;
import com.www.urlshortener.request.ShortenRequest;
import com.www.urlshortener.response.ShortenResponse;
import com.www.urlshortener.service.ShortenerApplicationService;

@SpringBootTest
class UrlshortenerApplicationTests {

	private static Logger log = LoggerFactory.getLogger(UrlshortenerApplicationTests.class);
	private final List<ShortenRequest> sites = Arrays.asList(new ShortenRequest("http://www.google.com/"),
			new ShortenRequest("http://www.facebook.com/"));

	@Autowired
	private ShortenerApplicationService shortenerApplicationService;

	@Test
	public void test() throws ShortenerException {
		sites.forEach(shortenRequest -> {
			ShortenResponse shortenUrl = shortenerApplicationService.shorten(shortenRequest.getUrl());
			log.info("{}", new Object[] { shortenUrl });

			Assert.assertNotNull(shortenUrl);

			String urlServ = shortenerApplicationService.getRedirectionUrl(shortenUrl.getUrlCode(), new HashMap<>());

			log.info("{}", new Object[] { urlServ });

			Assert.assertNotNull(urlServ);
			Assert.assertEquals(urlServ, shortenRequest.getUrl());
		});

	}

}
