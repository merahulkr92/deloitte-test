package com.www.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.www.urlshortener.domain.ShortenUrl;

@Repository
public interface ShortenerRepository extends JpaRepository<ShortenUrl, Long> {

	Optional<ShortenUrl> findByCode(String code);
}