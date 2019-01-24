package joowon.study.jpa.newpost;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(NewPostRepositoryTestConfig.class)
public class NewPostRepositoryTest {

    @Autowired
    NewPostRepository newPostRepository;

    @Test
    public void crud() {

        NewPost newPost = new NewPost();
        newPost.setTitle("test data");

        assertThat(newPostRepository.contains(newPost)).isFalse();

        newPostRepository.save(newPost.publish());

        assertThat(newPostRepository.contains(newPost)).isTrue();

        newPostRepository.delete(newPost);
        newPostRepository.flush();

    }

}