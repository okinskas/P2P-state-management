package com.okinskas.p2pmaster.data;

import java.util.UUID;

public interface Host {

    UUID getId();
    String getHostName();
    String getIp();
    String getPort();
}
