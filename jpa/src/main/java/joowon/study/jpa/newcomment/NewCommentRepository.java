package joowon.study.jpa.newcomment;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewCommentRepository extends JpaRepository<NewComment, Long> {

    @EntityGraph(attributePaths = "newPost")
    Optional<NewComment> getById(Long id);

}
