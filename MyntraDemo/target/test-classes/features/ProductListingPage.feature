Feature: Product Listing Page

  Background:
    Given User is on Myntra home page
    When user hovers on Women menu
    And user clicks on Indian Fusion Wear category

  @WomenNavigation
  Scenario: Verify product listing page is displayed
    Then product listing page should be displayed

  @categeoryfiltertest
  Scenario: Verify category filter reduces product count on PLP
    When User notes the product count before applying category filter
    And User selects category filter "Sarees"
    Then Product count should be updated after applying category filter

  @brandfiltertest
  Scenario: Verify user can filter products by brand
    When user apply brand filter
    Then only selected brand products should be displayed

  @ProductCount
  Scenario: Verify count of products in Product Listing Page
    Then user should see 50 products on Product Listing Page

  @PdpNavigation
  Scenario: Verify user can click product and navigate to PDP
    When user clicks on the first product
    And user switches to the new window
    Then user should be navigated to Product Detail Page

  @BrandMultipledatavalidation
  Scenario Outline: Verify user can filter products by multiple brands on PLP
    When user applies brand filter "<brand>"
    Then only selected brand "<brand>" products should be displayed

    Examples:
      | brand       |
      | Biba        |
      | SZN         |
      | Libas       |
      | Aurelia     |
      | Global Desi |
      | Sangria     |
      | Anouk       |
      | Varanga     |
