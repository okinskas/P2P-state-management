package com.okinskas.p2pclient.discovery;

import com.okinskas.common.Host;
import com.okinskas.p2pclient.discovery.usecase.FindHosts;

import java.util.List;

class DiscoveryController {

    private FindHosts findHosts;

    DiscoveryController(FindHosts findHosts) {
        this.findHosts = findHosts;
    }

    List<Host> findHosts() {
        return findHosts.find();
    }
}
