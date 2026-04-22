Feature: Product Listing Page

   @colorfiltertest
  Scenario: Verify category filter reduces product count on PLP
    Given User is on Myntra home page
    When User hovers on Women menu
    And User clicks on Indian Fusion Wear category
    And User notes the product count before applying category filter
    And User selects category filter "Sarees"
    Then Product count should be updated after applying category filter
    
    
    