package joowon.study.jpa.Account;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        this.createComment(55, "spring data1");
        this.createComment(100, "HIBERNATE SPRING");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));

        try(Stream<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest)) {
            Comment firstComment = comments.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(100);
        }
//        assertThat(comments.getNumberOfElements()).isEqualTo(2);
//        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100);
    }

    private void createComment(int like, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(like);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }

}