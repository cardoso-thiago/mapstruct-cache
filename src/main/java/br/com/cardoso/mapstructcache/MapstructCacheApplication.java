package br.com.cardoso.mapstructcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@SpringBootApplication
@EnableJpaRepositories("br.com.cardoso.mapstructcache.repository")
@EntityScan("br.com.cardoso.mapstructcache.entity")
@EnableCaching
@EnableScheduling
public class MapstructCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapstructCacheApplication.class, args);
    }
}
