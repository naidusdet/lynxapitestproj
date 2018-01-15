Feature: Investigate various details about countries in the world.

  @AllCountriesRetrievalEndPointScenario
  Scenario: Retrieve All countries information
    Given Countries retrieval rest endpoint is up
    When User access all countries information
    Then Returned JSON object is not null

  @SingleCountriesRetrievalEndPointScenario
  Scenario Outline: Retrieve a specific country information
    Given Countries retrieval rest endpoint is up
    When User retrieve a specific "<country>" information at a time
    Then Returned JSON object body should contain "<content>"
    Examples:
      | country        | content              |
      |  USA           | United States        |
      |  Australia     | Australia            |


  @StatusCode404CheckScenarioForInvalidCountryNameEntry
  Scenario Outline: Retrieve a 404 error message for an invalid country entry
    Given Countries retrieval rest endpoint is up
    When User retrieve a specific "<country>" information at a time
    Then Returned JSON object body For Invalid Entry should contain "<content>"
    Examples:
      | country        | content              |
      |  England       | 404                  |
