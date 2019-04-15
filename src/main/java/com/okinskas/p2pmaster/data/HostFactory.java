package com.okinskas.p2pmaster.data;

public interface HostFactory {

    Host create(String hostName, String ip, String port);
}
