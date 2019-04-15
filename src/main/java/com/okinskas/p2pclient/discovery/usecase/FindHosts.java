package com.okinskas.p2pclient.discovery.usecase;

import com.okinskas.common.Host;
import com.okinskas.p2pclient.discovery.domain.Discoverer;

import java.util.List;

public class FindHosts {

    private Discoverer discoverer;

    public FindHosts(Discoverer discoverer) {
        this.discoverer = discoverer;
    }

    public List<Host> find() {
        return discoverer.discover();
    }
}
