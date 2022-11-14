Feature: Login in the Home Page
  Scenario: Advisor can add appointment
    Given a user presses the login button
    When advisor name "prt582advisor@gmail.com" in the input
    And click next button
    And an advisor password "9841231598n" in the input
    And advisor click next button
    Then dashboard page is displayed
    And advisor section is clicked
    And appointment date is set
    And wait for datepicker
    And set date "21" text
    And set time "15:00" text
    And click submit button
    Then logout is clicked
    Then login page reached
    And close browser
  Scenario: Client can book and cancel appointment   
    Given a client presses the login button
    When client name "prt582client@gmail.com" in the input
    And client click username next button
    And a client password "9841231598n" in the input
    And client click password next button
    Then client dashboard page is displayed
    And client section is clicked
    And booking data are displayed
    And book first available date
    And booking section is clicked
    And client booking informations are displayed
    And cancel first booked date
    Then client logout is clicked
    Then client login page reached
  Scenario: Client send message to Advisor   
    Given a client presses the login button
    When client name "prt582client@gmail.com" in the input
    And client click username next button
    And a client password "9841231598n" in the input
    And client click password next button
    Then client dashboard page is displayed
    And section "client_chat" is clicked
    And open dropdown for "Ram sharma" with msg "Hello Ram"
  Scenario: Advisor replying to client message   
    Given a user presses the login button
    When advisor name "prt582advisor@gmail.com" in the input
    And click next button
    And an advisor password "9841231598n" in the input
    And advisor click next button
    Then dashboard page is displayed
    And section "advisor_chat" is clicked
    And open dropdown for "Aj Aj" with msg "Hello Aj"