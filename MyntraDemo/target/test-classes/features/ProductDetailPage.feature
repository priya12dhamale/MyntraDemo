Feature: Product Detail Page

@PdpNavigation
Scenario: Verify Product Detail Page opens when user clicks product
  Given user is on Women Indian Fusion Wear page
  When user clicks on the third product
  Then Product Detail Page should open in new window
  
  @PDP
Scenario: Verify same product brand displayed on PDP as selected on PLP
  Given user is on Women Indian Fusion Wear page
  When user captures the brand of the second product on PLP
  And user clicks on the second product
  Then same product brand should be displayed on Product Detail Page
  