package org.example.customloggerinterceptor.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Getter
public enum CacheTTL {

    USER(CacheName.USER, 20L, TimeUnit.MINUTES);

    private final String cacheName;
    private final Long duration;
    private final TimeUnit timeType;

    private static final List<CacheTTL> CACHE_TTL_LIST;

    static {
        CACHE_TTL_LIST = Arrays.stream(values()).toList();
    }

}
