package com.okinskas.p2pmaster.web;

import com.okinskas.p2pmaster.data.Host;
import com.okinskas.p2pmaster.master.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AppApi {

    private final MasterService masterService;

    @Autowired
    public AppApi(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping(path = "/hosts")
    public Iterable<Host> getHosts() {
        return masterService.getHosts();
    }

    @GetMapping(path = "/hosts/{id}")
    public ResponseEntity getHostById(
            @PathVariable("id") UUID id) {
        Optional<Host> optionalHost = masterService.getHostById(id);
        if (optionalHost.isPresent()) {
            return new ResponseEntity<>(optionalHost.get(), HttpStatus.OK);
        } else {
            String resp = String.format("Host with id %s does not exist.", id);
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Host> registerHost(
            @RequestParam("hostName") String hostName,
            @RequestParam("ip") String ip,
            @RequestParam("port") String port) {
        Host result = masterService.registerHost(hostName, ip, port);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteHost(
            @PathVariable("id") String uuid) {
        masterService.removeHost(UUID.fromString(uuid));
        return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
    }
}
