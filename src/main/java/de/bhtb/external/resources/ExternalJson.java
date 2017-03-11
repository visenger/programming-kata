package de.bhtb.external.resources;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by visenger on 11/03/17.
 */
public class ExternalJson {

    public static void main(String... args) {
        try {
            URL url = new URL("http://api.open-notify.org/astros.json");
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder jsonBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String str = scanner.next();
                jsonBuilder.append(str);
            }
            String json = jsonBuilder.toString();

            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement number = asJsonObject.get("number");
            int numberAsInt = number.getAsInt();
            System.out.println("number= " + numberAsInt);

            System.out.println(asJsonObject.toString() );

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
