

Feature: Purchase the order from Ecommerce  website
  I want to use this template for my feature file

Background:
Given  i landed on on ecommarce website 

  @tag2
  Scenario Outline: positive test in purchasing the order 
    Given Logged in with username <name> and password <password>
    When i add the product <productname> to cart
    And checkout <productname>and submit order
    Then "Thank you for the order" message dis-played om page
    

    Examples: 
      | name                    | password |productname|
      |  avik0811@gmail.com     | Jet@2015  |ZARA COAT 3| 
