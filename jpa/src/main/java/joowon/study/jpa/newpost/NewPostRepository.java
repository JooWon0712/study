package joowon.study.jpa.newpost;

import joowon.study.jpa.commonrepository.MyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewPostRepository extends MyRepository<NewPost, Long>, QuerydslPredicateExecutor<NewPost> {

    List<NewPost> findByTitleStartingWith(String title);

    @Query("SELECT np FROM #{#entityName} as np WHERE np.title = :title")
    List<NewPost> findByTitle(@Param("title") String keyword, Sort sort);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE NewPost np SET np.title = ?1 WHERE np.id = ?2")
    int updateTitle(String spring_data_jpa, Long id);
}
