package joowon.study.jpa.newcomment;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NewCommentRepository extends JpaRepository<NewComment, Long>
        , JpaSpecificationExecutor<NewComment>
        , QueryByExampleExecutor<NewComment> {

    @EntityGraph(attributePaths = "newPost")
    Optional<NewComment> getById(Long id);

    @Transactional(readOnly = true)
    <T> List<T> findByNewPost_Id(Long id, Class<T> type);
}
