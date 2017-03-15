package cn.edu.nju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Qiang
 * @since 18/02/2017
 */
@EnableScheduling
@SpringBootApplication
//@EnableJpaRepositories(repositoryBaseClass = CustomPayRecordRepositoryImpl.class)
public class Application {
    //TODO add Spring security
    // Not allow not active person or hotel to access those statistic page
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}