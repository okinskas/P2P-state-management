package com.okinskas.p2pmaster.external;

import com.okinskas.p2pmaster.data.HostRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface HostRepoImpl extends HostRepository<HostImpl>, CrudRepository<HostImpl, Long> {

    Iterable<HostImpl> findAll();
    Optional<HostImpl> findById(UUID uuid);

    void deleteById(UUID id);

    HostImpl save(HostImpl host);
}
