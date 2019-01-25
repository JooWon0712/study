package joowon.study.jpa.newcomment;

import joowon.study.jpa.newpost.NewPostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NewCommentRepositoryTest {

    @Autowired
    NewPostRepository newPostRepository;

    @Autowired
    NewCommentRepository newCommentRepository;

    @Test
    public void getNewComment() {
        newCommentRepository.getById(1l);

        System.out.println("=======================");

        newCommentRepository.findById(1l);

    }

}