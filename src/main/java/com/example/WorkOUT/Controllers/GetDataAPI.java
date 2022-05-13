package com.example.WorkOUT.Controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.programmerare.sweden_crs_transformations_4jvm.CrsProjection;
import com.programmerare.sweden_crs_transformations_4jvm.CrsCoordinate;

public class GetDataAPI {
    private ArrayList<GymObject> gymObjectList = new ArrayList<>();

    public static void main(String[] args) {
        GetDataAPI getDataAPI = new GetDataAPI();
        getDataAPI.loadFromAPI();
    }

    private void loadFromAPI() {
        try {
            URL url = new URL("https://apigw.stockholm.se/NoAuth/VirtualhittaserviceDMZ/Rest/serviceunits?&filter[servicetype.id]=122&page[limit]=1500&page[offset]=0&sort=name");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }

            String informationString = getJsonString(url);

            //JSON simple library Setup with Maven is used to convert strings to JSON
            JSONParser jsonParser = new JSONParser();
            JSONObject dataObject = (JSONObject) jsonParser.parse(informationString);

            JSONArray dataArray = (JSONArray) dataObject.get("data");

            fillGymObjectList(dataArray, gymObjectList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillGymObjectList(JSONArray dataArray, List<GymObject> list) {
        for (Object o : dataArray) {
            JSONObject vectorIndex = (JSONObject) o;
            JSONObject attributes = (JSONObject) vectorIndex.get("attributes");
            String gymName = (String) attributes.get("name");
            JSONObject location = (JSONObject) attributes.get("location");
            CrsCoordinate coordinate= getCoordinate(location);
            JSONObject relationships = (JSONObject) vectorIndex.get("relationships");
            JSONObject image = (JSONObject) relationships.get("image");
            JSONObject relationshipData = (JSONObject) image.get("data");
            String imageID = (String) relationshipData.get("id");

            GymObject retrievedGym = new GymObject(gymName, coordinate, imageID);
            list.add(retrievedGym);

            System.out.println(list);
        }
    }

    private CrsCoordinate getCoordinate(JSONObject location) {

        long lat = (Long) location.get("north");
        long lng = (Long) location.get("east");
        CrsCoordinate c = CrsProjection.SWEREF_99_18_00.createCoordinate(lat, lng);
        CrsCoordinate c2 = c.transform(CrsProjection.WGS84);
        return c2;
    }

    private String getJsonString(URL url) throws IOException {
        StringBuilder informationString = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            informationString.append(scanner.nextLine());
        }
        //Close the scanner
        scanner.close();
        return informationString.toString();
    }
}