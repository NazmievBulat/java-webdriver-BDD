package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.saveData;

public class RestClient {

    private static String authToken;

    public List<Map<String, Object>> getCandidates() {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .get("/candidates");

        // parse response
        List<Map<String, Object>> candidates = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");


        return candidates;


    }

    public void login(Map<String, String> credentials) {

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .header("Authorization" , getBasicAuthHeader())
                .header("Content-Type", "application/json")
                .body(credentials)
                .log().all();

        //execute request
        Response response = request
                .post("/login");

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String token = (String) result.get("token");
        authToken = "Bearer " + token;
    }

    public void logout() {

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", authToken)
                .header("Content-Type", "application/json")
                .log().all();

        //execute request
        Response response = request
                .post("/logout");

        // parse response
        response
                .then()
                .log().all()
                .statusCode(200);

    }


    public List<Map<String, Object>> getPositions() {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .get("/positions");

        // parse response
        List<Map<String, Object>> positions = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");


        return positions;


    }

    public Map<String, Object> getPositionById(int id) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .get("/positions/" + id);

        // parse response
        Map<String, Object> position = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");


        return position;

    }

    private String getBasicAuthHeader(){
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        //Decode from base64

        String authString = username + ":" + password;

        //encode for authorization

        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());

        String authorization = "Basic " + encodedAuthString;

        return authorization;

    }

    public int createPosition(Map<String, String> position) {
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .auth().preemptive().basic(username, password)
//                .header("Authorization" , getBasicAuthHeader())
                .header("Authorization", authToken)
                .header("Content-Type", "application/json")
                .body(position)
                .log().all();

        //execute request
        Response response = request
                .post("/positions/");

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        int id = (Integer) result.get("id");

        saveData("lastCreatedPositionId", id);

        return id;

    }

    public void updatePosition(int id, Map<String, String> position) {
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .auth().preemptive().basic(username, password)
//                .header("Authorization" , getBasicAuthHeader())
                .header("Authorization", authToken)
                .header("Content-Type", "application/json")
                .body(position)
                .log().all();

        //execute request
        Response response = request
                .patch("/positions/" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

//        int id = (Integer) result.get("id");
        //return id;

    }

    public int deletePosition(int id) {
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .auth().preemptive().basic(username, password)
//                .header("Authorization" , getBasicAuthHeader())
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                //.body(position)
                .log().all();

        //execute request
        Response response = request
                .delete("/positions/" + id);

        // parse response
        ValidatableResponse result = response
                .then()
                .log().all()
                .statusCode(204);
//                .extract()
//                .jsonPath()
               // .getMap("");

//        int id = (Integer) result.get("id");
        return id;

    }

    public Map<String, Object> getCandidateById(int id) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .get("/candidates/" + id);

        // parse response
        Map<String, Object> candidate = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");


        return candidate;

    }

    public int createCandidate(Map<String, String> candidate) {
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .auth().preemptive().basic(username, password)
//                .header("Authorization" , getBasicAuthHeader())
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .body(candidate)
                .log().all();

        //execute request
        Response response = request
                .post("/candidates/");

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        int id = (Integer) result.get("id");

        saveData("lastCreatedCandidateId", id);

        return id;

    }

    public int updateCandidate(Map<String, String> position, int id) {
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .auth().preemptive().basic(username, password)
//                .header("Authorization" , getBasicAuthHeader())
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .body(position)
                .log().all();

        //execute request
        Response response = request
                .put("/candidates/" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

//        int id = (Integer) result.get("id");
        return id;

    }
    public int deleteCandidate(int id) {
        Map<String, String> credentials = getData("recruiter", "careers");
        String username = credentials.get("username");
        String password = credentials.get("password");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .auth().preemptive().basic(username, password)
//                .header("Authorization" , getBasicAuthHeader())
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                //.body(position)
                .log().all();

        //execute request
        Response response = request
                .delete("/candidates/" + id);

        // parse response
        ValidatableResponse result = response
                .then()
                .log().all()
                .statusCode(204);
//                .extract()
//                .jsonPath()
        // .getMap("");

//        int id = (Integer) result.get("id");
        return id;

    }

    public int getPositionIdByTitle(String title) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .get("/positions?title=" + title);

        // parse response
        List<Map<String, Object>> positions = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        int id  = (Integer) positions.get(0).get("title");

        return id;


    }



    }



