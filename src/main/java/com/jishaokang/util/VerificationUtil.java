package com.jishaokang.util;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection.Response;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Created by NANA_Final on 2020/3/28.
 */
@Component
public class VerificationUtil {

    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    public void sendVerification(String phone) throws IOException {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 6;i++ ) sb = sb.append(random.nextInt(10));
        String verification = sb.toString();
        redisTemplate.opsForValue().set(verification,phone,5, TimeUnit.MINUTES);
        Response response = Jsoup.connect("http://yzx.market.alicloudapi.com/yzx/sendSms")
                .header("Authorization", "APPCODE " + "ee2457bc4b5b43a8975422133de4c528")
                .data("mobile",phone)
                .data("param","code:"+verification)
                .data("tpl_id", "TP19070343")
                .method(Method.POST)
                .execute();
        System.out.println(response.body());
    }
    public Boolean checkVerification(String phone,String verification){
        System.out.println(verification);
        if (redisTemplate.opsForValue().get(verification) == null) return false;
        if (!redisTemplate.opsForValue().get(verification).toString().equals(phone)) return false;
        return true;
    }

}