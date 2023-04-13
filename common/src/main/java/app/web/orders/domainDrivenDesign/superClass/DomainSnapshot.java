package app.web.orders.domainDrivenDesign.superClass;

import java.time.LocalDateTime;

public interface DomainSnapshot {
    long getId();

    long getVersion();

    String getUuid();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    default LocalDateTime getSnapshotCreatedAt() {
        return LocalDateTime.now();
    }

}
