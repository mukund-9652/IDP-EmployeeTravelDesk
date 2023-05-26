# EmployeeTravelDesk

## Module - Reimbursement Management

Once an employee is returned from their travel they will use this module to claim reimbursements for various expenses like food, daily transportation and laundry service which they utilized during their course of stay on the travel location. This module will provide the following facilities.
1. It will allow the employees to create a new Reimbursement request 
2. A travel desk executive can process the request by either accepting it or rejecting it 
3. The HRs should be able to see the expenses incurred by the employee under various expense types in the form of a report 

### Stage: Database Implementation 

1. Design a data base as per the following ER diagram provided.

![image](https://github.com/mukund-9652/EmployeeTravelDesk/assets/61533356/c89d3c35-08c6-43ae-bc6b-3f675c1b075d)

2. Enfore the following constraints along with primary and foreign keys 
    a. Request date must be automatically taken as current date 
    b. Allowed values for the status is – new/approved/rejected 
    c. ProcessedOn must not be a past date 
    d. Invoice date must be a passed date 

**Note**: Feed the data into the ReimbursementTypes table when the application starts. Values can be Food/Water/Laundry/LocalTravel 

### Stage: Data Access Layer Design 

1. Create a library project and add ORM support into it.  
2. Use the ORM to map the entities to database as per the ER diagram provided.
3. Use repository per entity pattern and generate the repositories to perform the following operations 
    a. Return the available Reimbursement types 
    b. Insert a new Reimbursement 
    c. Return all Reimbursements by travel request id 
    d. Process the reimbursement 
    e. Return a reimbursement by id 

### Stage: Business Logic Layer Development 

1. Develop a library which reference the Data Access Library project created earlier 
2. This class library will contain various service classes which will encapsulate the business logic for the application. 
3. Use dependency injection to in service classes to inject the required repositories. 
4. Create the service classes following the single responsibility principle which perform the given operations as follows  
    a. Return the available Reimbursement types 
    b. Insert a new Reimbursement 
    c. Return all Reimbursements by travel request id 
    d. Process the reimbursement 
    e. Return a reimbursement by id 
5. Following business rules must be implemented as part of the business service class 
    a. Allowed documents for uploading is pdf with the size of 256kb 
    b. Invoice date must be with in the from and to date of the travel which can be obtained from travel planner 
    c. If a reimbursement is rejected then a remarks must be provided. 
    d. The total allowed expense per day for food, laundry and local travel is as follows 
        i. Food and water – 1000-1500 per day 
       ii. Laundry – 250-500 per day 
      iii. Local travel – upto 1000 per day 

### Stage: Unit Testing 

1. Create a new Unit test project to test the service classes created in business logic layers 
2. Mock all the repositories using a mocking framework. 

### Stage: Micro-service implementation 

1. Create a API project which references the business logic layer created earlier 
2. Implement service documentation using swagger 
3. Create the following end-points and test them using postman and export the requests into a json file. 

#### Endpoint - 1 
![image](https://github.com/mukund-9652/EmployeeTravelDesk/assets/61533356/6e4cda6e-b9c0-4126-a340-e4b6f436259b)
#### Endpoint - 2
![image](https://github.com/mukund-9652/EmployeeTravelDesk/assets/61533356/113c56d8-0d01-4a5d-8190-0d547bb323ec)
#### Endpoint - 3
![image](https://github.com/mukund-9652/EmployeeTravelDesk/assets/61533356/6d42c9cc-4b44-4746-b9e8-d504597159da)
#### Endpoint - 4
![image](https://github.com/mukund-9652/EmployeeTravelDesk/assets/61533356/ee8714cc-33ab-4f18-b1ef-0a8fe9e6e6b3)
#### Endpoint - 5
![image](https://github.com/mukund-9652/EmployeeTravelDesk/assets/61533356/a0532af8-c074-4092-90e4-7ab873631186)
