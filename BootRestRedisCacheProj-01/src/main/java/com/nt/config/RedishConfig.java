package com.nt.config;

import java.time.Duration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@EnableCaching  //required for TTL
public class RedishConfig {
 

	
	@Bean
	public RedisCacheManager cacheManager(LettuceConnectionFactory redisConnectionFactory) //TTL
	{
	  RedisCacheConfiguration cacheConfig=RedisCacheConfiguration.defaultCacheConfig()
			  .entryTtl(Duration.ofMinutes(1))
			  .disableCachingNullValues();
	  return RedisCacheManager.builder(redisConnectionFactory)
			  .cacheDefaults(cacheConfig)
			  .build();
	}
	
	
}
