package com.okinskas.p2pmaster.data;

import com.okinskas.common.Host;

public interface HostFactory {

    Host create(String hostName, String ip, String port);
}
