package joowon.study.jpa;

import joowon.study.jpa.CommonRepository.CommonMyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CommonMyRepository.class)
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}

