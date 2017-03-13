package org.clayman.scoring.input.configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputServiceConfiguration {

    @Bean
    public Session session(Cluster cluster) {
        return cluster.connect();
    }

    @Bean
    public Cluster cluster() {

    }
}
