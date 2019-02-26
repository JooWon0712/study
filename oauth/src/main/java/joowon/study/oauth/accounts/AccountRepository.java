package joowon.study.oauth.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by JooWon0712.
 * User: joowon
 * Date: 2019-02-26
 * Time: 16:06
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserName(String userName);
}
