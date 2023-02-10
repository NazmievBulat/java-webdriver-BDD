@linkedin
Feature: LinkedIn Feature

  @LinkedIn1
  Scenario: Apply for easy jobs
    Given I open "linkedin" page
    And I Login to the linkedin account with "Login" and "Password"
    And I open "job" page
    And I apply for jobs