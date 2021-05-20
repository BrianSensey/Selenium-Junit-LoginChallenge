Feature: Login in Swag Labs
  As a customer user
  I like to login in Swag Labs Ecommerce

  Background:
    Given The user is on login page

  @Test
  Scenario Outline: 1 and 4. Successful login for valid users
    When The user enters the username <user> and password <pass>
    And The user logs in
    Then The Swaglabs ecommerce is opened
    And The header is displayed
    And Six products are displayed in the middle
    And The footer is displayed in the bottom

    Examples:
      |         user                 |        pass      |
      |    "standard_user"           |   "secret_sauce" |
      |    "performance_glitch_user" |   "secret_sauce" |

  @Test
  Scenario: 2. Successful login for valid user pressing Enter key
    When The user enters the username "standard_user" and password "secret_sauce"
    And The user press Enter
    Then The Swaglabs ecommerce is opened
    And The header is displayed
    And Six products are displayed in the middle
    And The footer is displayed in the bottom

  Scenario: 5. Successful login in different sessions
    And The user is on login page in a Firefox browser
    When The user enters the username "standard_user" and password "secret_sauce"
    And The user logs in
    And The user enters the username "standard_user" and password "secret_sauce"
    And The user logs in
    Then The Swaglabs ecommerce is opened
    And The Swaglabs ecommerce is opened

  @Test
  Scenario: 6. Verify alert "Username is required"
    When The user enters only a valid password "secret_sauce"
    And The user logs in
    Then An alert user required message is displayed "Epic sadface: Username is required"

  @Test
  Scenario: 7. Verify alert "Password is required"
    When The user enters the only a valid username "standard_user"
    And The user logs in
    Then An alert password required message is displayed "Epic sadface: Password is required"

  @Test
  Scenario: 8. Verify welcome landing page after login
    When The user enters the username "standard_user" and password "secret_sauce"
    And The user logs in
    Then The Swaglabs ecommerce is opened
    And The header is displayed

  @Test
  Scenario: 9. Failed login by entering unregistered user
    When The user enters the username "fake_user" and password "fake_sauce"
    And The user logs in
    Then An alert about unregistered user message is displayed "Epic sadface: Username and password do not match any user in this service"

  @Test
  Scenario: 10. Failed login by entering invalid password
    When The user enters the username "standard_user" and password "fake_sauce"
    And The user logs in
    Then An alert about unregistered user message is displayed "Epic sadface: Username and password do not match any user in this service"

  @Test
  Scenario: 11. Failed login by entering blank fields
    When The user enters the username "" and password ""
    And The user logs in
    Then An alert user required message is displayed "Epic sadface: Username is required"

  @Test
  Scenario: 12. Failed login for locked out user
    When The user enters the username "locked_out_user" and password "secret_sauce"
    And The user logs in
    Then An alert user required message is displayed "Epic sadface: Sorry, this user has been locked out."

  @Test
  Scenario: 13. Failed login due to server failure
    #Given The server is stopped
    When The user enters the username "standard_user" and password "secret_sauce"
    And The user logs in
    Then An error web page is displayed

  @Test
  Scenario: 3. Failed login for invalid user
    When The user enters the username "problem_user" and password "secret_sauce"
    And The user logs in
    Then The Swaglabs ecommerce is opened
    And A popup is displayed for update information