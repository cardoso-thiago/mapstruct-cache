package br.com.cardoso.mapstructcache.config;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@Configuration
public class CacheConfiguration {
    private final Logger log = Logger.getGlobal();

    @CacheEvict(value = {"getAll", "getAllDb"}, allEntries = true)
    @Scheduled(fixedDelay = 10000 ,  initialDelay = 10000)
    public void clearCache() {
        log.info("Cache cleared");
    }
}
