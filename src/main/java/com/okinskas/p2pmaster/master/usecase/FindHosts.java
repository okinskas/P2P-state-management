package com.okinskas.p2pmaster.master.usecase;

import com.okinskas.p2pmaster.data.Host;
import com.okinskas.p2pmaster.data.HostRepository;

import java.util.Optional;
import java.util.UUID;

public class FindHosts {

    private HostRepository<Host> hostRepository;

    public FindHosts(HostRepository<Host> hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Iterable<Host> findAll() {
        return hostRepository.findAll();
    }

    public Optional<Host> findById(UUID id) {
        return hostRepository.findById(id);
    }
}

