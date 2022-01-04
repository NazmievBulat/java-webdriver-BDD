@usps
Feature: Usps scenarios

  @usps1
  Scenario: Validate zip code for address
    Given I open "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "ca" state
#    And I wait for 5 sec
    Then I validate "94022" zip code exists in the result

  @usps2
  Scenario: Calculate price
    Given I open "usps" page
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.60"

 @usps3
  Scenario: Verify location
    Given I open "usps" page
    When I perform "Free boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

  @usps4
  Scenario: Every door direct mail
    Given I open "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary
#

  @usps5
  Scenario Outline: Validate zip codes for addresses
    Given I open "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<result>" zip code exists in the result
    Examples:
      |street                 |city             |state  |result|
      |22111 Erwin St         |Woodland Hills   |CA     |91367 |
      |6646 S Wadsworth Blvd  |Littleton        |CO     |80123 |
      |1800 15th Ave W        |Seattle          |WA     |98119 |

  @usps6
  Scenario: Quadcopters delivery
    Given I open "usps" page
    When I go to "FAQs" under "Help"
    And I perform "Quadcopters delivery" help search
#
    Then I verify that no results of "Quadcopters delivery" available in help search

  @usps7
  Scenario: Phone number of the nearest Mail Pickup
    Given I open "usps" page
    When I navigate to "Locations" heading link
    And I search for location "4970 El Camino Real 110, Los Altos, CA"
    Then I verify closest location phone number is "650-960-0817"


