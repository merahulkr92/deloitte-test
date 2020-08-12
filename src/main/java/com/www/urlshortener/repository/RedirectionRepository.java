package com.www.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.www.urlshortener.domain.Redirection;
@Repository
public interface RedirectionRepository extends JpaRepository<Redirection, Long> {
}
