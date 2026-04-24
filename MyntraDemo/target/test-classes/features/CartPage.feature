Feature: Cart Page Functionality

  Background:
    Given user is on home page
    When user hover on Women menu
    And user clicks on Indian Fusion Wear

  @Productdisplayverify
  Scenario: Verify product is displayed in cart after adding from PDP
    And user select category c "Kurtas"
    And user clicks product with index 1
    And user switches to new window
    And user selects size c "L"
    And user clicks on Add to Bag
    And user clicks on Go to Bag
    Then product should be displayed in cart

  @CartUrlNavigation
  Scenario: Verify cart page URL navigation after adding product
    And user select category c "Sarees"
    And user clicks product with index 2
    And user switches to new window
    And user clicks on Add to Bag
    And user clicks on Go to Bag
    Then cart page URL and title should be correct

  @PlaceOrderButton
  Scenario: Verify Place Order button is displayed when cart has items
    And user select category c "Dress Material"
    And user select colour "Pink"
    And user clicks product with index 1
    And user switches to new window
    And user clicks on Add to Bag
    And user clicks on Go to Bag
    Then Place Order button should be displayed in cart
    
    @EmptyCartNavigation
Scenario: Verify empty cart message when navigating directly to cart

  Given user navigates directly to cart page
  Then empty cart message should be displayed
  
  @ApplyCouponButton
Scenario: Verify Apply Coupon button is displayed in cart

  And user select category c "Sarees"
  And user select discount "40% and above"
  And user clicks product with index 1
  And user switches to new window
  And user clicks on Add to Bag
  And user clicks on Go to Bag
  Then Apply Coupon button should be displayed in cart
  
  @RemoveProduct
Scenario: Verify user can remove product from cart

  And user select category c "Sarees"
  And user clicks product with index 1
  And user switches to new window
  And user clicks on Add to Bag
  And user clicks on Go to Bag
  When user clicks on Remove button
  And user confirms remove product
  Then empty cart message should be displayed
  
  @InvalidPincode
Scenario: Verify error message displayed for invalid pincode on cart page

  And user select category c "Sarees"
  And user clicks product with index 1
  And user switches to new window
  And user clicks on Add to Bag
  And user clicks on Go to Bag
  When user clicks on Enter Pincode field
  And user enters invalid pincode "000000"
  And user clicks on Check button
  Then error message should be displayed for invalid pincode
