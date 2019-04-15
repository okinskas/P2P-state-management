package com.okinskas.p2pclient.discovery;

import com.okinskas.common.Host;
import com.okinskas.p2pclient.discovery.usecase.FindHosts;
import com.okinskas.p2pclient.discovery.domain.Discoverer;

import java.util.List;

public class DiscoveryService {

    private final DiscoveryController discoveryController;

    public DiscoveryService(Discoverer discoverer) {
        discoveryController = new DiscoveryController(
                new FindHosts(discoverer)
        );
    }

    public List<Host> findHosts() {
        return discoveryController.findHosts();
    }
}
