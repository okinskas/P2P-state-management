package com.okinskas.p2pmaster.master;

import com.okinskas.p2pmaster.data.Host;
import com.okinskas.p2pmaster.master.usecase.AddHost;
import com.okinskas.p2pmaster.master.usecase.DeleteHost;
import com.okinskas.p2pmaster.master.usecase.FindHosts;

import java.util.Optional;
import java.util.UUID;

public class MasterController {

    private final AddHost addHost;
    private final DeleteHost deleteHost;
    private final FindHosts findHosts;

    public MasterController(AddHost addHost,
                            DeleteHost deleteHost,
                            FindHosts findHosts) {
        this.addHost = addHost;
        this.deleteHost = deleteHost;
        this.findHosts = findHosts;
    }

    public Iterable<Host> findHosts() {
        return findHosts.findAll();
    }

    public Optional<Host> findHostById(UUID id) {
        return findHosts.findById(id);
    }

    public void removeHost(UUID id) {
        deleteHost.delete(id);
    }

    public Host registerHost(String hostName, String id, String port) {
        return addHost.add(hostName, id, port);
    }
}
