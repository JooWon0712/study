package joowon.study.jpa.Account;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

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
        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 7l);
        Comment comment = session.get(Comment.class, 8l);
        System.out.println("========================");
        System.out.println(post.getTitle());
        System.out.println("=====comments======");
        post.getComments().forEach(a -> {
            System.out.println(a.getComment());
        });

//        System.out.println(comment.getPost().getTitle());
//        System.out.println(comment.getComment());

    }
}
