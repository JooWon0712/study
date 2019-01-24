package joowon.study.jpa.account;

import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long> {

    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}