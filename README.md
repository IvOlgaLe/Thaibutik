# ThaiButik WebStore
WebStore platform by Olga Ive
Project has following features:
Administrator/Moderator features – menu "Admin"
 View all products and items
 Create product and product items
 Edit product and its items
 Set Item Availability
 Delete product and item (if it's possible, not allowed delete products if its items are in placed orders)
 View all orders
 Set Order Delivery Date and Status

User features
 Register new account
 Log In account
 Edit account info (phone, address, user name)
 Change password
 Log Out account
 Filter Product by Categories
 Search Product by Name
 Custom Product Search by – Type, Size, Price, Brand
 View Product details (Item)
 Add Item to Shopping Cart
 Remove Items from Cart
 Quick view Shopping Cart from the Navigation panel
 Buy Items function with Order creation
 View all Orders with details
 View Order Status and Delivery Date

Tech Stack
 Spring MVC
 Oracle
 Spring JDBC
 JSP
 CSS, Bootstrap
 


Steps for set up project:
===========
1. Clone the project 
2. Import in your IDE as maven project.
3. Go to Project Properties > Java Compiler > JDK Compliance and  adjust JDK Compliance accoriding to your JDK version.
4. Edit Database properties (file db.properties).
5. Init Database by running script initDB.sql (create tables).
6. Populate Database by running script dataDB.sql.
 WARNING: cleanDB.sql script drops all tables.
