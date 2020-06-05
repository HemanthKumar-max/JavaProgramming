package com.fundoonote.noteapi;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.fundoonote.noteapi.model.UserRegistration;
 
@Configuration
public class SpringRedisConfig {
	
    @Bean
    public JedisConnectionFactory connectionFactory() {
       return new JedisConnectionFactory();
    }
 

    @Bean
    public RedisTemplate redisTemplate() {
    	RedisTemplate<String,UserRegistration> redisTemplate = new RedisTemplate<>();
    	redisTemplate.setConnectionFactory(connectionFactory());
    	return redisTemplate;
}
}