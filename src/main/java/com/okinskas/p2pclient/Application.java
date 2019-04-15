package com.okinskas.p2pclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okinskas.common.Host;
import com.okinskas.p2pclient.discovery.DiscoveryService;
import com.okinskas.p2pclient.discovery.domain.Discoverer;
import com.okinskas.p2pclient.common.Master;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Basic example usage
        Master master = new Master("localhost", "8080", "hosts");
        Discoverer discoverer = new Discoverer(master);
        DiscoveryService discoveryService = new DiscoveryService(discoverer);

        List<Host> hosts = discoveryService.findHosts();
        ObjectMapper mapper = new ObjectMapper();

        for (Host host : hosts) {
            try {
                String jsonHost = mapper.writeValueAsString(host);
                System.out.println(jsonHost);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
