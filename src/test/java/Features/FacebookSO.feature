Feature: Facebook Automation

  Scenario Outline: To automate Facebook login page

    Given the user launches the facebook url
    Then the user verifies the facebook home page
    When the user enters "<username>" in username editbox
    And the user enters "<password>" in password editbox
    Then the user clicks on Login button
    Examples:
      | username | password |
  |admin       |admin123    |
  |tom         |jerry       |
  |hello       |world       |
  |apple       |mango       |

    #Given I launch the facebook url