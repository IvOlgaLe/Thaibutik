ThaiButik WebStore
===========
WebStore platform by Olga Ive

Project has following features:

Administrator/Moderator features – menu "Admin"
1. View all products and items
2. Create product and product items
3. Edit product and its items
4. Set Item Availability
5. Delete product and item (if it's possible, not allowed delete products if its items are in placed orders)
6. View all orders
7. Set Order Delivery Date and Status

User features
1. Register new account
2. Log In account
3. Edit account info (phone, address, user name)
4. Change password
5. Log Out account
6. Filter Product by Categories
7. Search Product by Name
8. Custom Product Search by – Type, Size, Price, Brand
9. View Product details (Item)
10. Add Item to Shopping Cart
11. Remove Items from Cart
12. Quick view Shopping Cart from the Navigation panel
13. Buy Items function with Order creation
14. View all Orders with details
15. View Order Status and Delivery Date

Tech Stack
1. Spring MVC
2. Oracle, MySQL(AWS), H2(JUnit test)
3. Spring JDBC
4. JSP
5. CSS, Bootstrap


Steps to set up project:
===========
1. Clone the project 
2. Import in your IDE as maven project.
3. Go to Project Properties > Java Compiler > JDK Compliance and  adjust JDK Compliance accoriding to your JDK version.
4. Edit Database properties (file db.properties).
5. Init Database by running script initDB.sql (create tables).
6. Populate Database by running script dataDB.sql. (WARNING: cleanDB.sql script drops all tables.)
