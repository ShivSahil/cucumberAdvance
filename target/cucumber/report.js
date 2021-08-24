$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("contactus.feature");
formatter.feature({
  "line": 2,
  "name": "Submit data to webdriveruniversity.com using contact us form",
  "description": "",
  "id": "submit-data-to-webdriveruniversity.com-using-contact-us-form",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@shivsahil"
    }
  ]
});
formatter.before({
  "duration": 3799619100,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Submit valid data via contact us form",
  "description": "",
  "id": "submit-data-to-webdriveruniversity.com-using-contact-us-form;submit-valid-data-via-contact-us-form",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I access webdriveruniversity contact us form",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter a valid firstname as \"Sahil\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I enter a valid last name",
  "rows": [
    {
      "cells": [
        "woods",
        "Shiva",
        "jones"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "i enter a valid email address as \"webdriveruniversity@outlook.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "i enter comments",
  "rows": [
    {
      "cells": [
        "example comment one",
        "example comment two"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "i click on the submit button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the information should successfully be submitted via the contact us form",
  "keyword": "Then "
});
formatter.match({
  "location": "ContactUsSteps.i_access_webdriveruniversity_contact_us_form()"
});
formatter.result({
  "duration": 1088145000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sahil",
      "offset": 30
    }
  ],
  "location": "ContactUsSteps.i_enter_a_valid_firstname_as(String)"
});
formatter.result({
  "duration": 230218800,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.i_enter_a_valid_last_name(DataTable)"
});
formatter.result({
  "duration": 168294000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "webdriveruniversity@outlook.com",
      "offset": 34
    }
  ],
  "location": "ContactUsSteps.i_enter_a_valid_email_address_as(String)"
});
formatter.result({
  "duration": 220138300,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.i_enter_comments(DataTable)"
});
formatter.result({
  "duration": 189637600,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.i_click_on_the_submit_button()"
});
formatter.result({
  "duration": 7044492500,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsSteps.the_information_should_successfully_be_submitted_via_the_contact_us_form()"
});
formatter.result({
  "duration": 71783600,
  "status": "passed"
});
formatter.after({
  "duration": 666215600,
  "status": "passed"
});
});