Feature: Facebook Automation

  Scenario: To automate Facebook login page

    Given the user launches the facebook url
    Then the user verifies the facebook home page
    When the user enters "tom" in username editbox
    And the user enters "pass123" in password editbox
    Then the user clicks on Login button

    #Given I launch the facebook url