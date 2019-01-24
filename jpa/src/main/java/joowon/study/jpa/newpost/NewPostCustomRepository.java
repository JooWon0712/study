package joowon.study.jpa.newpost;

import java.util.List;

public interface NewPostCustomRepository<T> {

    List<NewPost> findMyPost();

    void delete(T entity);
}
