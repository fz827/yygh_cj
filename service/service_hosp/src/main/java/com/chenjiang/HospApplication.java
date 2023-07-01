package com.chenjiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HospApplication.class,args);
    }
}
