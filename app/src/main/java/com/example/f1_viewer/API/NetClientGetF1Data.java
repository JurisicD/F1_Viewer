package com.example.f1_viewer.API;

public class NetClientGetF1Data {
   /* public List<F1_Drivers> getListOfDriversByYear(Integer nYear){
        List<F1_Drivers> driverList = new ArrayList<>();


        try {
            URL url = new URL("https://ergast.com/api/f1/"+ godina +"/drivers.json?callback=myParser");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output = br.readLine();
            output=output.replace("myParser(", "");
            output=output.replace(")","");

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(output);
            String sourceString = jsonNode.at("/MRData/DriverTable").toString();
            JSONObject jsonObject = new JSONObject(sourceString);
            JSONArray driversArray = jsonObject.getJSONArray("Drivers");

            for (int i = 0; i < driversArray.length(); i++){
                JSONObject newObject = new JSONObject(driversArray.get(i).toString());

                Drivers driver = new Drivers();
                driver.setCode(String.valueOf(newObject.optString("code")));
                driver.setDriverId(String.valueOf(newObject.optString("driverId")));
                driver.setPermanentNumber(String.valueOf(newObject.optString("permanentNumber")));
                driver.setNationality(String.valueOf(newObject.optString("nationality")));
                driver.setGivenName(String.valueOf(newObject.optString("givenName")));
                driver.setFamilyName(String.valueOf(newObject.optString("familyName")));
                driver.setDateOfBirth(String.valueOf(newObject.optString("dateOfBirth")));
                driver.setUrl(String.valueOf(newObject.optString("url")));

                driverList.add(driver);
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return driverList;
    }





        return driverList;
    }*/
}
