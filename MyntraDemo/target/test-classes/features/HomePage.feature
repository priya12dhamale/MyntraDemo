Feature: Women module navigation

  # Women Module Home Page Scenario 1
  Scenario: Verify user can open Women section
    Given User launches browser
    When User clicks on Women menu
    Then Women page should be displayed

  # Positive Scenario 2
  @WomenCategeoryTest
  Scenario: verify categories are displayed under Women section
    Given User is on Home page
    When user open Women page
    Then categories list should be displayed

  @SearchfunTest
  Scenario: Verify search functionality from home page
    Given User launches the browser
    When User enters "Dress" in search box
    And User clicks on search icon
    Then Relevant products should be displayed

  @CartNavigationTest
  Scenario: Verify user is able to navigate to cart page
    Given User launch the browser
    When User clicks on Cart icon
    Then User should be navigated to cart page

 #negative Scenario 2
   @SearchWithBlankField
  Scenario: Verify search with blank value in Women module
    When user presses search without entering product
    Then user should remain on home page
