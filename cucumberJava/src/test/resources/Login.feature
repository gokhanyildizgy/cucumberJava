Feature: Place Order Scenario
  Login with valid user
  Click first product
  Add to cart
  Complete purchase


  Scenario Outline: E2E Test
    Given I am in the homepage of the Demoblaze Application
    When I enter valid <username> and <password>
    Then I should login successfully
    And I click first product
    Then I click add to cart
    And I go to cart
    Then I click place order
    And I complete purchase


Examples:
    | username   | password |
    |  "bilyonerDemo"    | "b12345"   |
