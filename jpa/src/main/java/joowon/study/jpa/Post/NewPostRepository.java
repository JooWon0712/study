package joowon.study.jpa.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewPostRepository extends JpaRepository<NewPost, Long> , NewPostCustomRepository<NewPost> {

}
