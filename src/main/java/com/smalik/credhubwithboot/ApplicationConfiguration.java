package com.smalik.credhubwithboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Profile("local")
    @ConfigurationProperties("complex.config")
    public ServiceConfig localServiceConfig() {
        return new ServiceConfig();
    }

    @Bean
    @Profile("cloud")
    @ConfigurationProperties("vcap.services.credhub-svc.credentials.complex")
    public ServiceConfig cloudServiceConfig() {
        return new ServiceConfig();
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig defaultServiceConfig() {
        ServiceConfig config = new ServiceConfig();
        config.setUrl("http://unkn.own");
        config.setUsername("user");
        config.setPassword("password");
        return config;
    }

    public static class ServiceConfig {

        private String url;
        private String username;
        private String password;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
