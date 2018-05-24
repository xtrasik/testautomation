Feature: Test of content AddToYourOrder page

    @wordpress
    Scenario: Checking of CartSubtotal content
        Given User is on wordpress website "https://wordpress.com"

        When User clicks to login
        Then User is on first login page

        When User enter email and press Continue
        Then User is on second page password

        When User enter password and press LogIn
        Then User is on main login page
#
#        When User press avatar
#        Then User is personal page
#
#        When User click notification link
#        Then Notification page is displayed
#
#        When User press checkbox
#        Then Checkbox is unselected