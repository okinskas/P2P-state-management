package com.okinskas.p2pclient.discovery.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okinskas.common.Host;
import com.okinskas.p2pclient.common.HostAdapter;
import com.okinskas.p2pclient.common.Master;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Discoverer {

    private Master master;

    public Discoverer(Master master) {
        this.master = master;
    }

    public List<Host> discover() {

        StringBuilder response = new StringBuilder();

        try (InputStream stream = new URL(master.toString()).openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Host> hosts = new ArrayList<>();
        try {
            hosts = mapper.readValue(response.toString(), new TypeReference<List<HostAdapter>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hosts;
    }
}
