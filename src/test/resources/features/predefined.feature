@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//textarea[@id='APjFqb']" should be present
    When I type "Behavior Driven Development" into element with xpath "//textarea[@id='APjFqb']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"
    Then I switch to first window







#    Scenario: Valid Login and valid password
#      Given I open url "https://www.amazon.com/"
#      Then I should see page title contains "Amazon.com"
#      And I click on element with xpath "//span[@id='nav-link-accountList-nav-line-1']"
#      Then I wait for element with xpath "//div[@class='a-box']" to be present
#      And I type "nazmievbulat@gmail.com" into element with xpath "//input[@id='ap_email']"
#      And I click on element with xpath "//input[@id='continue']"















