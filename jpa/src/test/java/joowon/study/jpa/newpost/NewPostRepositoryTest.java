package joowon.study.jpa.newpost;

import com.querydsl.core.types.Predicate;
import joowon.study.jpa.account.QPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(NewPostRepositoryTestConfig.class)
public class NewPostRepositoryTest {

    @Autowired
    NewPostRepository newPostRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save() {
        NewPost newPost = new NewPost();
        newPost.setTitle("entityManager.persist");
        NewPost savePost = newPostRepository.save(newPost);

        savePost.setTitle("entityManager.merge");

        List<NewPost> all = newPostRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

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

    @Test
    public void crud2() {
        NewPost newPost = new NewPost();
        newPost.setTitle("hiber nate");
        newPostRepository.save(newPost.publish());

        Predicate predicate = QNewPost.newPost.title.containsIgnoreCase("hiber nate");
        Optional<NewPost> one = newPostRepository.findOne(predicate);
        assertThat(one).isNotEmpty();

    }

}