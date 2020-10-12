# SpringBootStudentsRepo
A SpringBoot Application that performs CRUD Operations using a MySql Database.

This Spring Boot Application takes Students Data and stores in MySql Database. This Application also performs GET,PUT and DELETE Operations in addition to CREATE.

Before running the project, reate a database in MySql. In appication.properties add your Database name in "spring.datasource.url=jdbc:mysql://localhost:3306/"****database_name****"?useSSL=false".

Also provide your MySql user name and password in "spring.datasource.username="****your mysql username****","spring.datasource.password=****your mysql password****" fields.

This application runs on port 9090. You can change it in application.properties in "server.port" field and MySql port is 3306.

Open-Api is used for documentation.
After running the application go to http://localhost:<youportnumber>/swagger-ui.html to perform CRUD operations.




