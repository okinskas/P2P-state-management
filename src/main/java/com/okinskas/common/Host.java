package com.okinskas.common;

import java.util.UUID;

public interface Host {

    UUID getId();
    String getHostName();
    String getIp();
    String getPort();
}
