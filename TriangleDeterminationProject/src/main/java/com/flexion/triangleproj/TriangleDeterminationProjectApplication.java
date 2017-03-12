package com.flexion.triangleproj;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TriangleDeterminationProjectApplication {

    public static void main(String[] args) {
        //In Spring Boot, when you try to create a Swing frame from the 
        //component that is the entry point of your app, you will get
        //java.awt.HeadlessException(A.N.)
        //SpringApplication.run(AlabamaHdiMliApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(TriangleDeterminationProjectApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }//end main
}//end TriangleDeterminationProjectApplication