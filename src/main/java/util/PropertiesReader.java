package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class will read information from the test.properties file in order to get the different paths towards needed files
 */
public class PropertiesReader {
    String result = "";
    InputStream inputStream;

    /**
     * It gets the information corresponding to the parameter from the test.properties file
     * @param propertie The ID of the path that is being asked
     * @return The path corresponding the the parameter
     * @throws IOException
     */
    public String getPropoValues(String propertie) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "test.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file" + propFileName + "Not found");
            }

            String path = prop.getProperty(propertie);
            result = path;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
        }
        return result;
    }
}