Feature: Login
  The login must behave according to the validity of the credential entered.

  Background: A web browser is at the login page
    Given a user opens a web browser and navigate towards login page

    @EXECUTE
  Scenario: Login unsuccessfully
      the user will try unsuccessfully to login and  a error message will be shown to him.
    When the user enters invalid credentials
    Then a "Credenciales invalidas!" message is shown
