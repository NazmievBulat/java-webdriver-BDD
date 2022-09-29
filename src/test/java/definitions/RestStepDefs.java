package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {
    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("automation", "position");
    Map<String, String> fieldsToUpdate = getData("automation_updated", "position");
    Map<String, String> John = getCandidateDataFromFile("John", "candidate");
    Map<String, String> JohnUpdated = getData("John updated", "candidate");
    int id;


    @Given("I work with rest api")
    public void iWorkWithRestApi() {
        //CRUD operations for positions
        Map<String, String> credentials = getData("recruiter", "careers");
        //Login
        restClient.login(credentials);

        //CREATE
        int createCandId = restClient.createCandidate(John);

        int createId = restClient.createPosition(automation);

        //READ
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createId);
        Map<String, Object> candidate = restClient.getCandidateById(createCandId);

        //UPDATE

        restClient.updatePosition(createId, fieldsToUpdate);
        int updateCandidate = restClient.updateCandidate(JohnUpdated, createCandId);

        //Map<String, Object> position1 = restClient.getPositionById(createId);


        //DELETE

        restClient.deletePosition(createId);
        restClient.deleteCandidate(createCandId);


    }

    @Given("I login via REST API as {string}")
    public void iLoginViaRESTAPIAs(String role) {
        Map<String, String> credentials = getData(role, "careers");
        //Login
        new RestClient().login(credentials);
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String type) {
        Map<String, String> position = getData(type, "position");
        new RestClient().createPosition(position);

    }

    @Then("I verify via REST API new {string} position is in the list")
    public void iVerifyViaRESTAPINewPositionIsInTheList(String type) {
        Map<String, String> expectedPosition = getData(type, "position");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        int expectedId = readTestDataInteger("lastCreatedPositionId");
        boolean isFound = false;
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");

            if (actualId == expectedId) {
                isFound = true;
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I update via REST API new {string} position")
    public void iUpdateViaRESTAPINewPosition(String type) {
        Map<String, String> fieldsToUpdate = getData(type + "_updated", "position");
        int positionIdToUpdate = readTestDataInteger("lastCreatedPositionId");
        restClient.updatePosition(positionIdToUpdate, fieldsToUpdate);
    }

    @Then("I verify via REST API new {string} position is updated")
    public void iVerifyViaRESTAPINewPositionIsUpdated(String type) {
        int positionIdUpdated = readTestDataInteger("lastCreatedPositionId");
        Map<String, String> expectedFields = getData(type + "_updated", "position");
        Map<String, Object> actualPosition = restClient.getPositionById(positionIdUpdated);

        for(String key : expectedFields.keySet()){
            System.out.println("Verify: " + key);
            System.out.println("Actual: " + actualPosition.get(key));
            System.out.println("Expected: " + expectedFields.get(key));
            expectedFields.get(key).equals(actualPosition.get(key));
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST API new position")
    public void iDeleteViaRESTAPINewPosition() {
        int positionIdToDelete = readTestDataInteger("lastCreatedPositionId");
        restClient.deletePosition(positionIdToDelete);
    }

    @Then("I verify via REST API new position is deleted")
    public void iVerifyViaRESTAPINewPositionIsDeleted() {
        int positionDeleted = readTestDataInteger("lastCreatedPositionId");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        boolean isFound = false;
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            assertThat(actualId).isNotEqualTo(positionDeleted);
        }
    }

    @And("I logout via REST API")
    public void iLogoutViaRESTAPI() {
        restClient.logout();
    }

    @When("I create via REST API {string} candidate")
    public void iCreateViaRESTAPICandidate(String type) {
        Map<String, String> candidate = getData(type, "candidate");
        new RestClient().createCandidate(candidate);

    }

    @Then("I verify via REST API new {string} candidate is in the list")
    public void iVerifyViaRESTAPINewCandidateIsInTheList(String type) {
        Map<String, String> expectedCandidate = getData(type, "candidate");
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        int expectedId = readTestDataInteger("lastCreatedCandidateId");
        boolean isFound = false;
        for (Map<String, Object> actualPosition : allCandidates) {
            int actualId = (Integer) actualPosition.get("id");

            if (actualId == expectedId) {
                isFound = true;
                break;
            }
        }
        assertThat(isFound).isTrue();
    }
}