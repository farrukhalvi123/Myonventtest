Feature: Register on Myonvent Website
  Scenario: Fill the Myonvent Registeration form
    Given User is on Chrome Browser
    And User is On MyOnvent Website
    Then Click on Join as Participant button
    Then Fill the 1st Step of Registeration form
    Then Upload the Image and Check the button
    Then Fetch OTP
    Then Complete the registeration process
#    Then Take Screenshot
    Then Post Message on live wall
    Then Logout
    Then Close the browser



