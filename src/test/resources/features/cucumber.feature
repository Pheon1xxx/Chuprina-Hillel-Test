Feature: cucumber

  Scenario: Check Logo
    Given user open home page
    When user click catalog Women
    And user click button logo
    Then site reload


  Scenario Outline: LogIn
    Given user open Sign In page
    When user insert <login> and <password>
    Then open account page

    Examples:
      | login                       | password       |
      | testingtesttestng@gmail.com | testNGtest1996 |


  Scenario: Add item in shopping cart
    Given user open Sale page
    When user click catalog Hoodies and Sweatshirts
    And user click item
    And user chooses size and color
    And user add item in shopping cart
    Then the line to go to the shopping cart appears


  Scenario: Remove item in shopping cart
    Given user open catalog Sale
    When user click catalog Jackets
    And user click item Olivia
    And user chooses size&color
    And user add item
    And user open shopping cart
    And user click remove shopping cart
    Then shopping cart clean


  Scenario Outline: Field Validation CreateAnAccount
    Given user open page CreateAnAccount
    When user insert first name <FirstName>
    And user insert  last name <LastName>
    And user insert email <EmailAddress>
    And user insert pass <Password>
    And user insert passConfirm <PasswordConfirm>
    Then fields must contain values
    Examples:
      | FirstName | LastName | EmailAddress                | Password       | PasswordConfirm |
      | Test      | Testing  | testingtesttestng@gmail.com | testNGtest1996 | testNGtest1996  |


  Scenario Outline: LogIn checkbox validation
    Given user open SignIn page
    When user inserts <Login> and <Pass>
    And user click catalog Sale
    And user click catalog Tees
    And user click Desiree Fitness Tee
    And user click ADD TO WISH LIST
    Then open page My Wish List

    Examples:
      | Login                       | Pass           |
      | testingtesttestng@gmail.com | testNGtest1996 |





