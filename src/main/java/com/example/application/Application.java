package com.example.application;

import org.apache.tomcat.util.buf.EncodedSolidusHandling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

/**
 * The entry point of the Spring Boot application.
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@SpringBootApplication
@Theme(value = "my-app")
public class Application implements AppShellConfigurator
{

    public static void main(String[] args)
    {
        System.setProperty( "org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true" );
        SpringApplication.run( Application.class, args );
    }

    @Bean
    TomcatConnectorCustomizer connectorCustomizer()
    {
        return (connector) -> connector.setEncodedSolidusHandling( EncodedSolidusHandling.DECODE.getValue( ) );
    }
}
