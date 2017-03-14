package org.clayman.scoring.input.configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.extras.codecs.jdk8.InstantCodec;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
public class InputServiceConfiguration {

    @Bean(destroyMethod = "close")
    public Session session(Cluster cluster) {
        return cluster.connect("online_scoring");
    }

    @Bean(destroyMethod = "close")
    public Cluster cluster() {
        Cluster cluster = Cluster.builder()
                .addContactPointsWithPorts(new InetSocketAddress("localhost", 9042))
                .build();
        cluster.getConfiguration().getCodecRegistry()
                .register(InstantCodec.instance);
        return cluster;
    }

    @Bean
    public MappingManager mappingManager(Session session) {
        return new MappingManager(session);
    }
}
