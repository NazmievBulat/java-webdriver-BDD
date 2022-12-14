@careers
Feature: Careers feature

  @careers1
  Scenario: Recruiter removes position

    Given I open "careers" page
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I remove "Principal Automation Engineer" position
    And I verify "Principal Automation Engineer" position is removed

  @careers2 @cleanup_position
  Scenario: Recruiter creates position

    Given I open "careers" page
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create new position
    Then I verify new position is created
    When I remove new position
    And I verify new position is removed

