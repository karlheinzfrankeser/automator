package com.frankeser.webapp.config;

import com.ticinocom.tools.cdi.config.Configuration;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

public class ApplicationConfiguration extends Configuration {

    private static final String APPLICATION_CONFIG_NAME = "automator";

    @Inject
    private Event<ApplicationConfiguration> configurationReLoaded;

    @PostConstruct
    private void init() {
        this.initConfig(APPLICATION_CONFIG_NAME);
    }

    @Override
    protected void readProperties() {

    }

    public void reloadConfiguration() {
        try {
            this.log.info("Re-initializing configuration...");
            this.loadConfiguration(APPLICATION_CONFIG_NAME);
            this.configurationReLoaded.fire(this);
            this.log.info("Configuration successfully re-loaded.");
        } catch (Exception ex) {
            this.log.error("Exception thrown while re-loading configuration: {}", ex.getMessage(), ex);
            throw new RuntimeException("Unable to reload configuration.", ex);
        }
    }

}
