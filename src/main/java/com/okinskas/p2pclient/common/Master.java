package com.okinskas.p2pclient.common;

import lombok.Data;

@Data
public class Master {

    private String ip;
    private String port;
    private String ext;

    public Master(String ip, String port, String ext) {
        this.ip = ip;
        this.port = port;
        this.ext = ext;
    }

    @Override
    public String toString() {
        return String.format("http://%s:%s/%s", ip, port, ext);
    }
}
