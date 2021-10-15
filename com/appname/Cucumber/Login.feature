Feature: Login to RealEstate

Background:
Given User is in login page

  Scenario Outline: Successful login    
    When user enters correct "<Username>" and "<Password>" and clicks login
    Then User homepage should be loaded successfully

    Examples:
    |Username    |Password    |
    |Sushmitha s |89710 30229 |
    |Test1001    |Test123     | 