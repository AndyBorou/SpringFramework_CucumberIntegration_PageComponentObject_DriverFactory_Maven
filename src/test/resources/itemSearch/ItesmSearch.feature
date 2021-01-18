Feature: Item search

  Background:

    Given Customer opens Home page

  @Dress
  Scenario: Search items with valid query
    When Customer searches for "dress" item
    Then SearchResults page is opened
    And Valid search results are displayed for query "dress" on SearchResults page

  Scenario: Search items with invalid query
    When Customer searches for "sdfgsdf" item
    Then SearchResults page is opened
    And No results are displayed on SearchResults page



