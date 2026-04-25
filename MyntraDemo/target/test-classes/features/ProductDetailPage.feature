Feature: Product Detail Page

  @PdpNavigation
  Scenario: Verify Product Detail Page opens when user clicks product
    Given user is on Women Indian Fusion Wear page
    When user clicks on the third product
    Then Product Detail Page should open in new window

  @BrandVerification
  Scenario: Verify same product brand displayed on PDP as selected on PLP
    Given user is on Women Indian Fusion Wear page
    When user captures the brand of the second product on PLP
    And user clicks on the second product
    Then same product brand should be displayed on Product Detail Page

  @PriceVerification
  Scenario: Verify product price is displayed on Product Detail Page
    Given user navigates to Women Indian Fusion Wear category
    When user clicks on the first product from search results
    Then product price should be displayed on Product Detail Page

  @diffSizeOptions
  Scenario: Verify different size options are displayed on Product Detail Page
    Given user navigates to Women Indian Fusion Wear category
    When user clicks on the first product from search results
    Then different size options should be displayed on Product Detail Page

  @sizeSelection
  Scenario: Verify user can select size and add product to bag
    Given user navigates to Women Indian Fusion Wear category
    And user selects category "Kurtas"
    When user clicks the first product from search results
    And user selects size "M"
    And user clicks on Add to Bag button
    Then size selection should be successful

    @addToBag
  Scenario: Verify user can add product to bag successfully
    Given user navigates to Women Indian Fusion Wear category
    And user select category "Jeggings"
    When user click on the first product from search results
    And user select size "40"
    And user clicks Add to Bag button
    Then product should be added to bag successfully
  
 @addMultipleSizesPDP
Scenario Outline: Verify user can add product to bag for different sizes PDP
  Given user navigates to Women Indian Fusion Wear category
  And user select category "<category>" PDP
  When user click on the first product from search results PDP
  And user select size "<size>" PDP
  And user clicks Add to Bag button PDP
  Then product should be added to bag successfully PDP

Examples:
  | category | size |
  | Kurtas   | S    |
  
  @invalidPincodeValidation
Scenario Outline: Verify error message is displayed for invalid pincode values on PDP
  Given user opens any product detail page
  When user provides invalid pincode "<invalidPin>"
  And user taps on Check availability button
  Then invalid pincode warning message should appear

Examples:
  | invalidPin |
  | 123        |
  
  @validPincodeValidation
Scenario Outline: Verify delivery information is shown for valid pincode values on Product Detail Page
  Given shopper lands on a product detail screen
  When shopper submits serviceable pincode "<validPin>"
  And shopper presses Check delivery button
  Then delivery details should be visible for that pincode

Examples:
  | validPin |
  | 411057   |
  | 411014   |
  | 411001   |
  | 560001   |
  | 400001   |
  
