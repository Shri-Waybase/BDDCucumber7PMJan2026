Feature: Add Supplier functionality

  @SupplierwithDatatable
  Scenario: To validate the add supplier functionality
    Given The user is on the Login page
    When  The user enters valid credentials
      | username | password |
      | admin    | admin    |
    And   The user clicks on the login button
    And   The user can see the dashboard
    And   The user click on the add supplier link
    And   The user enters the supplier details
      | name        | address                   | contact1   | contact2   |
      | MAC Service | 56 Industrial Area, Texas | 9980776655 | 8977665544 |
    And   The user click on add supplier button
    Then  The supplier is added successfully


  @EG
  Scenario Outline: To add 5 suppliers to repository
    Given The user is on the Login page
    When  The user enters valid credentials
      | username | password |
      | admin    | admin    |
    And   The user clicks on the login button
    And   The user can see the dashboard
    And   The user click on the add supplier link
    And   The user enters the "<name>","<contact1>","<contact2>","<address>" supplier details
    And   The user click on add supplier button
    Then  All the supplier is added successfully
    Examples:
      | name             | contact1   | contact2   | address                 |
      | QAQ MDI Service  | 9876543210 | 9123456789 | 12  Area, New York      |
      | ASA Traders      | 9988776655 | 8877665544 | Market Road, California |
      | AZWZ Supplies    | 9090909090 | 8080808080 | Tech, San Jose          |
      | XWQ Distributors | 9797979797 | 9696969696 | Warehouse Zone, Dallas  |
      | WQE Enterprises  | 9567891234 | 9345678123 | Business Bay, Chicago   |


