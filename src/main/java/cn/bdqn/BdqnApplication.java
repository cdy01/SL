package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@EnableJpaRepositories(basePackages = {"cn.bdqn.dao"})*/

@SpringBootApplication
public class BdqnApplication
{

    public static void main(String[] args) {
        SpringApplication.run(BdqnApplication.class, args);
    }

}
