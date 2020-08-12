package com.www.urlshortener.domain;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="redirection")
public class Redirection {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="shortenUrlId")
    private ShortenUrl shortenUrl;

    @Column(name="redirectDate")
    private LocalDateTime redirectDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sourceInfoId")
    private SourceInfo sourceInfo;

    public Redirection() {
    }

    public Redirection(ShortenUrl shortenUrl, SourceInfo sourceInfo) {
        setShortenUrl(shortenUrl);
        setSourceInfo(sourceInfo);
        setRedirectDate(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public ShortenUrl getShortenUrl() {
        return shortenUrl;
    }

    public LocalDateTime getRedirectDate() {
        return redirectDate;
    }

    public SourceInfo getSourceInfo() {
        return sourceInfo;
    }

    private void setShortenUrl(ShortenUrl shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

    private void setRedirectDate(LocalDateTime redirectDate) {
        this.redirectDate = redirectDate;
    }

    private void setSourceInfo(SourceInfo sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    @Override
    public String toString() {
        return "Redirection{" +
                "id=" + id +
                ", shortenUrl=" + shortenUrl +
                ", redirectDate=" + redirectDate +
                ", sourceInfo=" + sourceInfo +
                '}';
    }
}