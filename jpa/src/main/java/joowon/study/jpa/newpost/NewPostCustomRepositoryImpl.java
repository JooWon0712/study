package joowon.study.jpa.newpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class NewPostCustomRepositoryImpl implements NewPostCustomRepository<NewPost> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<NewPost> findMyPost() {
        System.out.println("=========== custom findMyPost");
        return entityManager.createQuery("SELECT p FROM NewPost AS p").getResultList();
    }

    @Override
    public void delete(NewPost entity) {
        System.out.println("=========== custom delete");
        entityManager.remove(entity);
    }
}
