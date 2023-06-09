# Account creation api
**Requirements**

* The API will expose an endpoint which accepts the user information (customerID, initialCredit).
* Once the endpoint is called, a new account will be opened connected to the user whose ID is customerID.
* Also, if initialCredit is not 0, a transaction will be sent to the new account.
* Another Endpoint will output the user information showing Name, Surname, balance, and transactions of the accounts.

**Spring boot API**

*Actuator endpoints:*

http://{host}:{management-port}/actuator

**OpenAPI definition swagger UI**

http://{host}:{management-port}/actuator/swagger-ui/index.html

**Api Endpoints**

* POST - /api/v1/account      Create account form existing customer
* GET - /api/v1/account?account={account-id}  Get account and transaction details of an account


**Technology**
* Java 20 open-jdk
* Spring boot
* Spring Data JPA
* H2 Database