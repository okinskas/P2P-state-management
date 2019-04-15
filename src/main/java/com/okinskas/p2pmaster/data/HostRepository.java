package com.okinskas.p2pmaster.data;

import java.util.Optional;
import java.util.UUID;

public interface HostRepository<T> {

    Iterable<T> findAll();
    Optional<T> findById(UUID id);

    void deleteById(UUID id);

    T save(T host);
}
