package joowon.study.jpa.Post;

import java.util.List;

public interface NewPostCustomRepository<T> {

    List<NewPost> findMyPost();

    void delete(T entity);
}
