package definitions;

import io.cucumber.java.en.And;
import pages.LinledinJobsPage;
import pages.LinledinLoginPage;

public class LinkedinStepDefs {
    LinledinLoginPage login = new LinledinLoginPage();
    LinledinJobsPage jobs = new LinledinJobsPage();

    @And("I Login to the linkedin account")
    public void iLoginToTheLinkedinAccount() {


        login.loginIn();




    }


    @And("I apply for jobs")
    public void iApplyForJobs() {
        jobs.applyForJobs();
    }
}
