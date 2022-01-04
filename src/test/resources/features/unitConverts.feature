@unitConverts
  Feature: UnitConverts scenarios


    @unitConverts1
    Scenario: Validate converts fahrenheit to celsius
      Given I open "unitConverts" page
      And I select "Temperature" in menu
      And I fill out "54" "Fahrenheit"
      Then I verify result has "12.2" "Celsius"

    @unitConverts2
    Scenario: Validate converts pound to kilogram
      Given I open "unitConverts" page
      And I select "Weight" in menu
      And I fill out "170" "Pound"
      Then I verify result has "77" "Kilogram"

    @unitConverts3
    Scenario: Validate converts mile to kilometer
      Given I open "unitConverts" page
      And I select "Length" in menu
      And I fill out "50" "Mile"
      Then I verify result has "80.4" "Kilometer"

