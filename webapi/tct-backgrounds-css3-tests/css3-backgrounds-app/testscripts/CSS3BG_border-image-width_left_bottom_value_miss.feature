Feature: css3-backgrounds
 Scenario: CSS3BG border image width left bottom value miss
   When launch "css3-backgrounds-app"
     And I go to "backgrounds/CSS3BG_border-image-width_left_bottom_value_miss-manual.html"
     And I save the page to "CSS3BG_border-image-width_left_bottom_value_miss"
    Then pic "CSS3BG_border-image-width_left_bottom_value_miss" of baseline and result should be "100" similar if have results