package joowon.study.jpa.newpost;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewPostRepositoryTestConfig {

    @Bean
    public ApplicationListener<NewPostPublishedEvent> newPostListener() {
        return newPostPublishedEvent -> {
            System.out.println("=================================");
            System.out.println(newPostPublishedEvent.getNewPost().getTitle()+" is published!!");
            System.out.println("=================================");
        };
    }
}
