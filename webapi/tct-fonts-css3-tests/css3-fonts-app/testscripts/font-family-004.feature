Feature: css3-fonts
 Scenario: font family 004
   When launch "css3-fonts-app"
     And I go to "fonts/csswg/font-family-004-manual.htm"
     And I save the page to "font-family-004"
     And I save the screenshot md5 as "font-family-004"
    Then file "font-family-004" of baseline and result should be the same
