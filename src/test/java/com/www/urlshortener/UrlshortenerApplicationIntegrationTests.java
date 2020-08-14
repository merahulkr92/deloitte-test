package com.www.urlshortener;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.www.urlshortener.request.ShortenRequest;
import com.www.urlshortener.response.ShortenResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UrlshortenerApplicationIntegrationTests {

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate;

	private HttpHeaders headers;

	@BeforeEach
	public void setUp() {
		restTemplate = new TestRestTemplate();
		headers = new HttpHeaders();
	}

	@AfterEach
	public void tearDown() {
		restTemplate = null;
		headers = null;
	}

	@Test
	public void test() {

		HttpEntity<ShortenRequest> entity = new HttpEntity<ShortenRequest>(new ShortenRequest("http://www.google.com"),
				headers);

		ResponseEntity<ShortenResponse> response = restTemplate.exchange(createURLWithPort("/shortener"),
				HttpMethod.POST, entity, ShortenResponse.class);

		ShortenResponse responsebody = response.getBody();

		Assert.assertNotNull(responsebody);

		ResponseEntity<String> response2 = restTemplate.exchange(
				createURLWithPort("/shortener/" + responsebody.getUrlCode()), HttpMethod.GET,
				new HttpEntity<String>(null, headers), String.class);
		Assert.assertTrue(response2.getStatusCode().toString().equals("200 OK"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
