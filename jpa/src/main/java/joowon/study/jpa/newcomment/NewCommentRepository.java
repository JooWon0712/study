package joowon.study.jpa.newcomment;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewCommentRepository extends JpaRepository<NewComment, Long> {

    @EntityGraph(attributePaths = "newPost")
    Optional<NewComment> getById(Long id);

    <T> List<T> findByNewPost_Id(Long id, Class<T> type);
}
