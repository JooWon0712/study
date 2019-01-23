package joowon.study.jpa.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /* 1번 */
//        Account account = new Account();
//        account.setUsername("joowon");
//        account.setUserpassword("joowon0712");
//
//        Study study = new Study();
//        study.setName("Spring Data Jpa");
//
//        account.addStudy(study);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
//        session.save(study);
//
//        Account joowon = session.load(Account.class, account.getId());
//        joowon.setUsername("min young");
//        System.out.println("================");
//        System.out.println(joowon.getUsername());
//        entityManager.persist(account);

        /* 2번 */
//        Post post = new Post();
//        post.setTitle("JPA 공부");
//
//        Comment comment = new Comment();
//        comment.setComment("열씸히 하세요!!");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("더 분발하세요");
//        post.addComment(comment1);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(post);

        /* 3번 */
//        Session session = entityManager.unwrap(Session.class);
//        Post post1 = session.get(Post.class, 1l);
//        session.delete(post1);

        /* 4번 */
//        Session session = entityManager.unwrap(Session.class);
//        Post post = session.get(Post.class, 7l);
//        Comment comment = session.get(Comment.class, 8l);
//        System.out.println("========================");
//        System.out.println(post.getTitle());
//        System.out.println("=====comments======");
//        post.getComments().forEach(a -> {
//            System.out.println(a.getComment());
//        });

//        System.out.println(comment.getPost().getTitle());
//        System.out.println(comment.getComment());

        /* 5번 (JPQL) */
        /*
        딘점 : Type safe하지 못하다.
         */
//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);

        /* 6번 (Criteria) */
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Post> query = builder.createQuery(Post.class);
//        Root<Post> root = query.from(Post.class);
//        query.select(root);
//
//        List<Post> posts = entityManager.createQuery(query).getResultList();
//        posts.forEach(System.out::println);

        /* 7번 (Native Query */
//        List<Post> posts = entityManager.createNativeQuery("SELECT * FROM Post", Post.class).getResultList();
//        posts.forEach(System.out::println);

        /* 8번 Spring Data JPA 사용 */
        postRepository.findAll().forEach(System.out::println);

    }
}
