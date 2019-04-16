package com.okinskas.p2pclient.state.domain;

import java.io.Serializable;

public interface State extends Serializable {

    int getUpdateCount();
    int getTrackedInteger();
    int incrementTrackedInteger();
    int decrementTrackedInteger();
}
