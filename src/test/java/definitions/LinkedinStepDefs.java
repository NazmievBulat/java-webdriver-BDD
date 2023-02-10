package definitions;

import io.cucumber.java.en.And;
import pages.LinkedinJobsPage;
import pages.LinkedinLoginPage;

public class LinkedinStepDefs {
    LinkedinLoginPage login = new LinkedinLoginPage();
    LinkedinJobsPage jobs = new LinkedinJobsPage();

    @And("I Login to the linkedin account")
    public void iLoginToTheLinkedinAccount() {
        login.loginIn();
    }


    @And("I apply for jobs")
    public void iApplyForJobs() {
        jobs.applyForJobs();
    }
}
