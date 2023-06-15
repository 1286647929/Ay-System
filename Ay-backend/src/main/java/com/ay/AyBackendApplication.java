package com.ay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.ay.system.mapper"})
public class AyBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(AyBackendApplication.class, args);
    }

}
