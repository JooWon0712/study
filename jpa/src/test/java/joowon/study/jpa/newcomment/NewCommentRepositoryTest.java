package joowon.study.jpa.newcomment;

import joowon.study.jpa.newpost.NewPost;
import joowon.study.jpa.newpost.NewPostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static joowon.study.jpa.newcomment.NewCommentSpecs.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NewCommentRepositoryTest {

    @Autowired
    NewPostRepository newPostRepository;

    @Autowired
    NewCommentRepository newCommentRepository;

    @Test
    public void qbe() {
        NewComment prove = new NewComment();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnoreCase("up", "down");

        Example<NewComment> example = Example.of(prove, exampleMatcher);

        newCommentRepository.findAll(example);
    }

    @Test
    public void specs() {
        newCommentRepository.findAll(isBest().or(isGood()), PageRequest.of(0, 10));
    }

    @Test
    public void getNewComment_Projection() {
        NewPost newPost = new NewPost();
        newPost.setTitle("new Post");
        NewPost savedPost = newPostRepository.save(newPost);

        NewComment newComment = new NewComment();
        newComment.setNewPost(savedPost);
        newComment.setNewComment("new Comment");
        newComment.setUp(10);
        newComment.setDown(1);
        newCommentRepository.save(newComment);

        newCommentRepository.findByNewPost_Id(savedPost.getId(), NewCommentOnly.class).forEach(c->
        {
            System.out.println("======================");
            System.out.println(c.getNewComment());
        });
    }

    @Test
    public void getNewComment() {
        newCommentRepository.getById(1l);

        System.out.println("=======================");

        newCommentRepository.findById(1l);

    }

}