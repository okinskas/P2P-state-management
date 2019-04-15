package com.okinskas.p2pmaster.external;

import com.okinskas.common.Host;
import com.okinskas.p2pmaster.data.HostFactory;

public class HostFactoryImpl implements HostFactory {

    @Override
    public Host create(String hostName, String ip, String port) {
        return new HostImpl(hostName, ip, port);
    }
}
