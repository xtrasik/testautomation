package com.jsystems.frontendBDD;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    public static final Config CONFIG=ConfigFactory.load("config.conf");
    public static final String ENVIRONMENT = CONFIG.getString("environment");
    public static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String WORDPRESS_EMAIL = ENV.getString("login");
    public static final String WORDPRESS_PASSWORD = ENV.getString("password");
    public static final String WORDPRESS_BASE_URL = ENV.getString("baseUrl");
}
