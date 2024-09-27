Feature: Build jenkins job
  Scenario: Verify jenkins job created successfully
    Given user opens the website
    Then verify user is on login page
    When user enters username "valid.username" and password "valid.password"
    And click on submit button
    Then verify user is on home page
    When user click on New Item from side bar
    And automatically generate item name
    And click on freestyle project
    And click on ok button
    Then verify user is on configuration page
    When user select git from source code management
    And enter the git repository URL
    And click on Add build step
    And select Invoke top-level Maven targets
    And enter the "clean install" command
    And click on add post-build action
    And select cucumber reports
    And click on save
    Then verify user is logged out successfully


