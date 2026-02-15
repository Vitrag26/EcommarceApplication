
Feature: Error Validation
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Title of your scenario outline
    Given i landed on on ecommarce website 
    When  Logged in with username <name> and password <password>
    Then "Incorrect username ands password" message is displayed

    Examples: 
      
      | name                    | password |
      |  avikddd0811@gmail.com     | Jetdd@2015  |