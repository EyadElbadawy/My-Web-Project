Feature: F01_Search | user could search for a lesson

  Background: nagwa website is available
    Given user open the website

  Scenario Outline: guest user search for a lesson and go to worksheet section
    Given user select "english" language
    When user write "<searchWord>" in search field
    And user select second search result "<searchWord>"
    And user go to worksheet section
    Then questions displayed

    Examples: list of lessons names - valid
    |searchWord    |
    |addition      |
    |subtraction   |
    |multiplication|
    |division      |












