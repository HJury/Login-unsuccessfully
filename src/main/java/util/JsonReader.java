package util;

import interactions.Exceptions;
import org.apache.xmlbeans.SystemProperties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    static PropertiesReader propertiesReader;

    /**
     * This method search on the dataDrive.json file for an array called as the parameter that received
     * @param packageName   The name of the array that has yet to be found
     * @return A JSONObject instance that contains information from dataDrive.json
     */
    static public JSONObject getInfoPackage(String packageName) {
        JSONObject obj2 = new JSONObject();
        try {
            propertiesReader = new PropertiesReader();
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(SystemProperties.getProperty("user.dir") + propertiesReader.getPropoValues("JsonPath"));
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            obj2 = (JSONObject) obj.get(packageName);
        } catch (IOException e) {
            Exceptions.exceptionMessage(e);
        } catch (ParseException e) {
            Exceptions.exceptionMessage(e);
        } finally {
            return obj2;
        }
    }


    static public String getValueFromPackage(JSONObject jsonObject, String key) {
        return (String) jsonObject.get(key);
    }

}
