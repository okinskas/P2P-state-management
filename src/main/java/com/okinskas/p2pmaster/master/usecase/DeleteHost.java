package com.okinskas.p2pmaster.master.usecase;

import com.okinskas.p2pmaster.data.HostRepository;

import java.util.UUID;

public class DeleteHost {

    private HostRepository hostRepository;

    public DeleteHost(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public void delete(UUID id) {
        hostRepository.deleteById(id);
    }
}
