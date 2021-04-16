Feature: End point testing

  Scenario: Create list update delete user
    Given user get url "https://gorest.co.in/public-api/users/"
    When user is created
    Then verify the status code is 200
    And verify if your id it is in the list
    * Update user and verify that status code is 200
    * delete user and verify that status code is 200
