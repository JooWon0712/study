package joowon.study.jpa.newpost;

import joowon.study.jpa.commonrepository.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NewPostRepository extends MyRepository<NewPost, Long>, QuerydslPredicateExecutor<NewPost> {

}
