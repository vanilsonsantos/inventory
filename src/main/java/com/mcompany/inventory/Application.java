package com.mcompany.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        ApplicationContext context = new FileSystemXmlApplicationContext("/migrations/dao.xml");
//        context.getBean("mongeez");
//        String webPort = System.getenv("PORT");
//        if (webPort == null || webPort.isEmpty()) {
//            webPort = "8080";
//        }
//        System.setProperty("server.port", webPort);
        SpringApplication.run(Application.class, args);
    }
}
