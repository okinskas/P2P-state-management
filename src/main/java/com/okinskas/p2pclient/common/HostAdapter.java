package com.okinskas.p2pclient.common;

import com.okinskas.common.Host;

import java.util.UUID;

public class HostAdapter implements Host {

    private UUID id;
    private String hostName;
    private String ip;
    private String port;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getHostName() {
        return hostName;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public String getPort() {
        return port;
    }
}
