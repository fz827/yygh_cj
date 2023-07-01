package com.chenjiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerUserApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerUserApplication.class,args);
    }
}
