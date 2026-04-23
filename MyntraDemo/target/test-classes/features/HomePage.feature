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
# negative Scenario 2

  @SearchWithBlankField
  Scenario: Verify search with blank value in Women module
    When user presses search without entering product
    Then user should remain on home page

  @SearchproductTest
  Scenario Outline: Verify search functionality for multiple women products
    When user search for the Various "<product>"
    Then user should see the result for the valid product

    Examples:
      | product         |
      | Kurtas          |
      | Kurtis          |
      | Sarees          |
      | Ethnic Wear     |
      | Leggings        |
      | Skirts          |
      | Dress Materials |
      | Lehenga Cholis  |
      | Dupattas        |
      | Jackets         |
      | Dresses         |
      | Tops            |
      | Tshirts         |
      | Jeans           |
      | Trousers        |
      | Shorts          |
      | Co-ords         |
      | Playsuits       |
      | Jumpsuits       |

  @SearchSuggestion
  Scenario: Verify search using suggestions
    When user searches for the product using suggestions "Women Top"
    Then users should navigate to the correct PLP page for "Women Top"
    
    @WishlistWithoutLogin
Scenario: Verify wishlist access without login
  When user click on wishlist icon
  Then user should be redirected to login page
  
  
  @InvalidSearch
Scenario: Verify search using random number
  When user search for the product "123456789"
  Then user should see no results message
