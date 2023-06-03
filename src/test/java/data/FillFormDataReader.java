package data;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class FillFormDataReader {


    public String name,gender,countryname;


    public void jreader() throws FileNotFoundException, IOException, ParseException {

        String path ="E://AppiumProjects//AppiumFrameworkDesign//src//test//java//data//FillFormData.json";
        File srcfile = new File(path);
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcfile));

        for(Object yobject : jarray) {

            JSONObject person = (JSONObject) yobject;
            countryname=(String) person.get("countryname");
            name=(String) person.get("name");
            gender=(String) person.get("gender");


        }


    }


}