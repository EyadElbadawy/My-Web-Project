Feature: F02_Languages | user could select language

  Background: nagwa website is available
    Given user open the website

  Scenario Outline: guest user select language
    When user select "<language>"
    Then the "<language>" is selected

    Examples: list of languages options - valid
      |language   |
      |english    |
      |spanish    |
      |french     |
      |portuguese |
      |arabic     |




