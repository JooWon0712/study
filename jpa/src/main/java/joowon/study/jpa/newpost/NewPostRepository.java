package joowon.study.jpa.newpost;

import joowon.study.jpa.commonrepository.MyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface NewPostRepository extends MyRepository<NewPost, Long>, QuerydslPredicateExecutor<NewPost> {

    List<NewPost> findByTitleStartingWith(String title);

    @Query("SELECT np FROM NewPost as np WHERE np.title = ?1")
    List<NewPost> findByTitle(String title, Sort sort);

}
