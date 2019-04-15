package com.okinskas.p2pmaster.master.usecase;

import com.okinskas.p2pmaster.data.Host;
import com.okinskas.p2pmaster.data.HostFactory;
import com.okinskas.p2pmaster.data.HostRepository;

public class AddHost {

    private HostRepository hostRepository;
    private HostFactory hostFactory;

    public AddHost(HostRepository hostRepository, HostFactory hostFactory) {
        this.hostRepository = hostRepository;
        this.hostFactory = hostFactory;
    }

    public Host add(String hostName, String ip, String port) {
        Host host = hostFactory.create(hostName, ip, port);
        return (Host) hostRepository.save(host);
    }
}
