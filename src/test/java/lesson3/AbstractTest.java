package lesson3;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    static Properties properties = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String url;
    private static String getUrl;
    private static String postUrl;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/resources.properties");
        properties.load(configFile);

        apiKey =  properties.getProperty("apiKey");
        url= properties.getProperty("url");
        getUrl=properties.getProperty("getUrl");
        postUrl=properties.getProperty("postUrl");

    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getUrl() {
        return url;
    }

    public static String getGetUrl() {
        return getUrl;
    }

    public static String getPostUrl() {
        return postUrl;
    }
}
