package definitions;

import io.cucumber.java.en.And;
import pages.LinkedinJobsPage;
import pages.LinkedinLoginPage;

public class LinkedinStepDefs {
    LinkedinLoginPage login = new LinkedinLoginPage();
    LinkedinJobsPage jobs = new LinkedinJobsPage();



    @And("I apply for jobs")
    public void iApplyForJobs() {
        jobs.applyForJobs();
    }

    @And("I Login to the linkedin account with {string} and {string}")
    public void iLoginToTheLinkedinAccountWithAnd(String loginCredential, String passwordCredential) {
        login.loginIn(loginCredential, passwordCredential);
    }
}
