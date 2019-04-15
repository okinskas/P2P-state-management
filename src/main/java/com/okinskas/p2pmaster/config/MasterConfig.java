package com.okinskas.p2pmaster.config;

import com.okinskas.p2pmaster.data.HostFactory;
import com.okinskas.p2pmaster.external.HostFactoryImpl;
import com.okinskas.p2pmaster.external.HostRepoImpl;
import com.okinskas.p2pmaster.master.MasterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MasterConfig {

    @Bean
    public HostFactory hostFactory() {
        return new HostFactoryImpl();
    }

    @Bean
    public MasterService masterService(
            HostRepoImpl hostRepo,
            HostFactory hostFactory) {
        return new MasterService(hostRepo, hostFactory);
    }
}
