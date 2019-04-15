package com.okinskas.p2pmaster.external;

import com.okinskas.p2pmaster.data.Host;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "hosts")
public class HostImpl implements Host {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "hostName")
    private String hostName;

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private String port;

    protected HostImpl() {}

    public HostImpl(String hostName, String ip, String port) {
        this.hostName = hostName;
        this.ip = ip;
        this.port = port;
    }
}
