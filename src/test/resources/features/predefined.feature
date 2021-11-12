@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"
    Then I switch to first window

    @predefined2
    Scenario: Predefined steps for Yahoo
      Given I open url "https://www.yahoo.com"
      Then I should see page title contains "Yahoo"
      Then element with xpath "//input[@id='ybar-sbq']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='ybar-sbq']"
      Then I click on element with xpath "//input[@id='ybar-search']"
      Then I wait for element with xpath "//div[@id='doc']" to be present
      Then element with xpath "//div[@id='doc']" should contain text "Cucumber"

      @predefined3
      Scenario: Predefined steps for Bing
        Given I open url "https://www.bing.com"
        Then I should see page title as "Bing"
        Then element with xpath "//input[@id='sb_form_q']" should be present
        When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
        Then I click on element with xpath "//label[@id='search_icon']"
        Then I wait for element with xpath "//body" to be present
        Then element with xpath "//body" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//body/div[1]" to be present
    Then I wait for 1 sec
    Then element with xpath "//body/div[1]" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for Duckduckgo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//*[@class='results--main']" to be present
    Then element with xpath "//*[@class='results--main']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    Then I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//*[@class='web-results']" to be present
    Then element with xpath "//*[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then I wait for 1 sec
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Search Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@class='search-form-home__button-desktop']//div[@class='ico']"
    Then I wait for element with xpath "//div[@class='layout-web__mainline']" to be present
    Then I wait for 1 sec
    Then element with xpath "//div[@class='layout-web__mainline']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Search Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title contains "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    Then I click on element with xpath "//button[contains(@class, 'mini-suggest')]"
    Then I wait for element with xpath "//*[@class='main__content']" to be present
    Then element with xpath "//*[@class='main__content']" should contain text "BDD"

  @predefined10
  Scenario: Predefined steps for Search Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    Then I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    And I wait for 1 sec
    Then element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Search Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
#    And I wait for 1 sec
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

    @predefined12
    Scenario: Validate responsive UI of quote page
      Given I open url "https://skryabin.com/market/quote.html"
      And I resize window to 400 and 800
      Then element with xpath "//b[@id='location']" should not be displayed
      And I resize window to 1200 and 800
      Then element with xpath "//b[@id='location']" should be displayed

      @predefined13
      Scenario: Validate min length username
        Given I open url "https://skryabin.com/market/quote.html"
        When I type "a" into element with xpath "//input[@name='username']"
        And I click on element with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='username-error']" should contain text "2 char"
        But I type "b" into element with xpath "//input[@name='username']"
        And I click on element with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='username-error']" should not contain text "2 char"

  @predefined14
  Scenario: Validate “Email” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should contain text "valid email"
    But I type "@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not contain text "valid email"

  @predefined15
  Scenario: Fill out and validate “Password” set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "a" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled

  @predefined16
  Scenario: Validate that Accepting Privacy Policy is required to
  submit the form, then check the field.
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And I type "John" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Lock" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "John10" into element with xpath "//input[@name='username']"
    And I type "John10@mail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[contains(text(),'Must check!')]" should be displayed


  @predefined17
  Scenario: Validate “Name” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    And I type "John" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Lock" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@value='John M Lock']" should be displayed

  @predefined18
  Scenario: Try entering the following non-required fields in the order:
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "6578785978" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[contains(@ng-model, 'formData.country')]/option[@value='USA']"
    And I type "45345 dfgeg" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//input[@value='male']"
    And I click on element with xpath "//option[@value='Toyota']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "45345 dfgeg" into element with xpath "//textarea[@id='address']"
    And I type "13/12/2001" into element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert


  @predefined19
  Scenario: Submit the form and verify the data.
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And I type "John" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Lock" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "John10" into element with xpath "//input[@name='username']"
    And I type "John10@mail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='password']" should not contain text "12345"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "John10@mail.com"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "John M Lock"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "John10"





#    Scenario: Valid Login and valid password
#      Given I open url "https://www.amazon.com/"
#      Then I should see page title contains "Amazon.com"
#      And I click on element with xpath "//span[@id='nav-link-accountList-nav-line-1']"
#      Then I wait for element with xpath "//div[@class='a-box']" to be present
#      And I type "nazmievbulat@gmail.com" into element with xpath "//input[@id='ap_email']"
#      And I click on element with xpath "//input[@id='continue']"















