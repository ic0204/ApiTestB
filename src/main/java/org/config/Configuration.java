
package org.config;

import java.util.Properties;

public class Configuration {
    private static Properties properties = new Properties();

    static {
        // Burada yapılandırma dosyasından çeşitli ortam ayarlarını yükleyebilirsiniz.
        properties.setProperty("baseURI", "https://dummy.restapiexample.com/api/v1");
    }

    public static String getBaseURI() {
        return properties.getProperty("baseURI");
    }
}

