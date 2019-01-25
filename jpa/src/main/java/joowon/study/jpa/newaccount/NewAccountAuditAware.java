package joowon.study.jpa.newaccount;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewAccountAuditAware implements AuditorAware<NewAccount> {
    @Override
    public Optional<NewAccount> getCurrentAuditor() {
        System.out.println("looking for current user");
        return Optional.empty();
    }
}
