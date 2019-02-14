package com.frankeser.webapp;

import com.frankeser.webapp.config.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@WebListener
@ApplicationPath("/")
public class ContextListener extends Application implements ServletContextListener {

    @Inject
    private Logger log;

    @Inject
    private ApplicationConfiguration config;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.log.info("Initializing context...");

        this.setupLogging();
        //...

        this.log.info("Context initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.log.info("Context destroyed.");
    }

    private void setupLogging() {
        final ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        this.log.info("Setting log level to '{}'", this.config.getLogLevel());
        if (rootLogger.getLevel() != this.config.getLogLevel()) {
            rootLogger.setLevel(this.config.getLogLevel());
        }
    }
}
