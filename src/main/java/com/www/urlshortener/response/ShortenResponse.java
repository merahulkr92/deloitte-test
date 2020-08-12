package com.www.urlshortener.response;

import java.time.LocalDateTime;

public class ShortenResponse {

	private Long urlId;

	private String urlCode;

	private LocalDateTime createdAt;

	private Boolean status;

	public ShortenResponse(Long urlId, String urlCode, LocalDateTime createdAt, Boolean status, String description) {
		setUrlId(urlId);
		setUrlCode(urlCode);
		setCreatedAt(createdAt);
		setStatus(status);
	}

	public Long getUrlId() {
		return urlId;
	}

	public String getUrlCode() {
		return urlCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Boolean getStatus() {
		return status;
	}

	private void setUrlId(Long urlId) {
		this.urlId = urlId;
	}

	private void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}

	private void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	private void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShortenResponse{" + "urlId=" + urlId + ", urlCode='" + urlCode + '\'' + ", createdAt=" + createdAt
				+ ", status=" + status + '\'' + '}';
	}
}