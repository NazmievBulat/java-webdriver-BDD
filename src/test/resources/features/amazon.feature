@amazon

  Feature: Amazon check books

  @amazon1

  Scenario: Search for Java For Testers
    Given I open "Amazon" page
    When I select "Books" department in the searchbox
    And I search for book in main page
    Then I verify the book with the right name is appears




















#  Go to amazon page
#  Search for "Java for Testers" in "Books" department
#  Verify it contains "Learn Java fundamentals fast"
#
#  Go to amazon page
#  Search for "software architecture" in "Audible Books & Originals" department
#  Verify it contains "Clean Architecture"
