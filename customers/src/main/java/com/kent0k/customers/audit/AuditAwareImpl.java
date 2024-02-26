package com.kent0k.customers.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<Integer> {

    private static final int ADMIN_BD_ID = 1;

    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.of(ADMIN_BD_ID);
    }
}
