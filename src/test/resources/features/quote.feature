@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I open "quote" page
      And I multi select "Ford", "Toyota", "BMW"
      And  I print logs to the console
      When I fill out required page
#      And I fill out optional page
      And I wait for 5 sec
#      And I go to the "google" page
#      And I go back
#      And I go forward
#      Then I refresh the page
#      And I	change resolution to "phone"
      And I submit the page
      Then I verify the required fields
#      Then I verify the optional fields

