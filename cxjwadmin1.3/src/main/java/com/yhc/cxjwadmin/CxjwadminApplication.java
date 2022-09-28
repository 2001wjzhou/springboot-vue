package com.yhc.cxjwadmin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CxjwadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxjwadminApplication.class, args);
        log.info("cxjwadmin已启动!");
    }

}
