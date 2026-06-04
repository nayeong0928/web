package kr.co.shortenurlservice.domain;

import java.util.List;

public interface ShortenUrlRepository {
    void saveShortenUrl(ShortenUrl shortenUrl);
    List<ShortenUrl> findAll();
    ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);
}
