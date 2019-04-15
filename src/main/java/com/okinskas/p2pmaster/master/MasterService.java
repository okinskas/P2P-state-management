package com.okinskas.p2pmaster.master;

import com.okinskas.p2pmaster.data.Host;
import com.okinskas.p2pmaster.data.HostFactory;
import com.okinskas.p2pmaster.data.HostRepository;
import com.okinskas.p2pmaster.master.usecase.AddHost;
import com.okinskas.p2pmaster.master.usecase.DeleteHost;
import com.okinskas.p2pmaster.master.usecase.FindHosts;

import java.util.Optional;
import java.util.UUID;

public class MasterService {

    private final MasterController masterController;

    public MasterService(HostRepository repository, HostFactory hostFactory) {
        masterController = new MasterController(
                new AddHost(repository, hostFactory),
                new DeleteHost(repository),
                new FindHosts(repository)
        );
    }

    public Iterable<Host> getHosts() {
        return masterController.findHosts();
    }

    public Optional<Host> getHostById(UUID id) {
        return masterController.findHostById(id);
    }

    public void removeHost(UUID id) {
        masterController.removeHost(id);
    }

    public Host registerHost(String hostName, String ip, String port) {
        return masterController.registerHost(hostName, ip, port);
    }
}
