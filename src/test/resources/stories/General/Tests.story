Meta:

@test

Scenario: Check the 1st scenario

Given user is on the Home Page
When user selects Desktops from the Computers categories menu
And user sets Display 4 per page
And user checks that only 4 items are displayed on the page
Then user selects Sort by Price: High to Low
And user clicks Add to cart for the most expensive product from the category page
And user clicks Add to cart button from the product page
And user checks that message The product has been added appears
And user opens Shopping cart page
And check that item is added to the cart


Scenario: Check the 2nd scenario

Given user is on the product page
And user wants to use product with specific options
And user wants to use software:
|software|
|Image Viewer|
|Office Suite|
|Other Office Suite|
When user selects processor
And user selects ram
And user selects software
Then user clicks Add to Cart button
And sub-total amount is calculated
And user opens Shopping cart page
And check that item is added to the cart
And check that actual sub-total amount is correct
And user removes item from the shopping cart
And user checks that shopping cart is empty

Examples:
|itemName|itemProcessor|itemRam|itemPrice|
|Build your own expensive computer|Fast|8GB|1800.00|











