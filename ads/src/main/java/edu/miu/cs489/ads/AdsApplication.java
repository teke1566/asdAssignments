package edu.miu.cs489.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("edu.miu.cs489.ads.model")
public class AdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsApplication.class, args);
    }

}
