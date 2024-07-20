Feature: Grid Validation

  Scenario: User looks for a row on the current pagination of grid
    Given the page loads successfully
    And the user scrolls to the "Grid filter row server data" component
    When the user looks for a row with ID "2025"
    Then the user should be able to validate the row values of ID "2025"
