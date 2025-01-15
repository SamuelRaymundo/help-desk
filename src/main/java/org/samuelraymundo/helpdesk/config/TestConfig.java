package org.samuelraymundo.helpdesk.config;

import org.samuelraymundo.helpdesk.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBServices dbServices;

    @Bean
    public Boolean instantiateDb() {
        this.dbServices.instantiateDb();
        return true;
    }
}
