package com.chenjiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerOrderApplication
{
    public static void main( String[] args )
    {

        SpringApplication.run(ConsumerOrderApplication.class,args);
    }
}
