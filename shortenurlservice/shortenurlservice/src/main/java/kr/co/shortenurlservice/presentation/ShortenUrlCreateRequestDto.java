package kr.co.shortenurlservice.presentation;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public class ShortenUrlCreateRequestDto {

    @NotNull
    @URL(regexp = "^(https?:\\/\\/)(([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}|localhost|\\d{1,3}(\\.\\d{1,3}){3})(:\\d+)?(\\/[^\\s]*)?$")
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }
}
