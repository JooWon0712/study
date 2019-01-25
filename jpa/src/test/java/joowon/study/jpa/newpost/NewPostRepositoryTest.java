package joowon.study.jpa.newpost;

import com.querydsl.core.types.Predicate;
import joowon.study.jpa.account.QPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
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

    @Test
    public void updateTitle() {
        NewPost newPost = saveNewPost();

        String hibernate = "hibernate";
        // 방법 1 (추천하지 않음)
//        int update = newPostRepository.updateTitle(hibernate, newPost.getId());
//        assertThat(update).isEqualTo(1);
//
//        Optional<NewPost> byId = newPostRepository.findById(newPost.getId());
//        assertThat(byId.get().getTitle()).isEqualTo(hibernate);

        // 방법 2
        newPost.setTitle(hibernate);
        List<NewPost> all = newPostRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(hibernate);
    }

    private NewPost saveNewPost() {
        NewPost newPost = new NewPost();
        newPost.setTitle("Spring Data JPA");
        return newPostRepository.save(newPost);
    }

    @Test
    public void findByTitle() {
        saveNewPost();

        List<NewPost> all = newPostRepository.findByTitle("Spring Data JPA", JpaSort.unsafe("LENGTH(title)"));
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartWith() {
        saveNewPost();

        List<NewPost> all = newPostRepository.findByTitleStartingWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

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