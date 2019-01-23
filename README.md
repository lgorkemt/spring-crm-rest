. The application is a simple Spring rest application for allowing user to make CRUD operations on a list of customers.
The code is written by using Chad Darby's Udemy course on Spring framework (https://www.udemy.com/spring-hibernate-tutorial/)

. A Mysql DB and workbench should be installed to the local machine which the application is going to run. (MySQL can be 
downlaoded from http://dev.mysql.com/downloads)

. Open MySql workbench and run three scripts respectively; 
    01-create-user.sql, 
    02-customer-tracker.sql, 

These scripts would create a db user called springstudent, create the DB schema called web_customer_tracker, 
create a Customer table, populate the Customer table.

. Open the source code for the appropriate version

. Run the application: 
   a. Select the root project folder
   b. Right-Click, select Run As > Run On Server (A tomcat server should have been installed in your local machine)
   c. The application is secured by using Spring security. In memory authentication is used to store users and roles.
    (You may find the available users and their roles in DemoSecurityConfig.java)
   d. EMPLOYEE role can perform following;
   
      1. Get a list of all customers. GET /api/customers
      2. Get a single customer. GET /api/customers/{customerId}
      
      MANAGER role can perform following in addition to EMPLOYEE;
      
      1. Add a new customer. POST /api/customers
      2. Update an existing customer. PUT /api/customers
      
      ADMIN role can perform following in addition to MANAGER;
      
      1. Delete a customer. DELETE /api/customers/{customerId}
  
      User 'susan' with the password test123 has the admin rights, can perform all actions.
  
     
   e. If you have Postman installed, you may make the following HTTP requests (Do not forget to enter the credentials
   susan, test123 in the authorization tab); 
   
   
    GET http://localhost:8080/spring-crm-rest/api/customers (Selects all customers)
    GET http://localhost:8080/spring-crm-rest/api/customers/1 (Select customer with having the id 1)
    POST http://localhost:8080/spring-crm-rest/api/customers (Insert a new customer)
   
    Body;
   
    {
   	  "id":0,
      "firstName": "Gorkem",
      "lastName": "Turan",
      "email": "gorkem@luv2code.com"
    }
   
    PUT http://localhost:8080/spring-crm-rest/api/customers (Update the customer with having the id 6)
      
    Body;
    
    {
      "id":6,
      "firstName": "Gorkem",
      "lastName": "Turan",
      "email": "gorkem.turan@luv2code.com"
    }
    
    DELETE http://localhost:8080/spring-crm-rest/api/customers/6 (Delete the customer with the id 6)
   
. Also aspects are added for logging the CRUD actions. You may check your console after each action for
the logs written by the aspects.

