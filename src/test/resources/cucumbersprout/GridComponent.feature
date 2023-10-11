Feature: Grid Validation

  Scenario: User looks for a row on the current pagination of grid
    Given the page loads successfully
    And the user scrolls to the "Grid, search using parent binding" component
    When the user looks for a row with ID "2011"
    Then the user should be able to validate the row values of ID "2011"
