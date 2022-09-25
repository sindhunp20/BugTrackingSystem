# BugTrackingSystem
Tools used :-

Java development Kit = jdk 16.0.2

Apache Tomcat version 10

MySQL Version = 8.0.30


jar files used :-

1. mysql-connector-java-8.0.30.jar - Since MYSQL database is used, this is require for database connectivity.

2. apache commons - These jars are for the file upload functionality. The json file is uploaded to the server for importing users. The files are then read from the request object.


Configurations :-

1. Set the JAVA_HOME variable to the relevant jdk path and make sure that its bin folder is added to the path variable.

2. Similarly, Set the TOMCAT_HOME variable and its path value as the folder where tomcat is extracted.

3. Import the project to the Spring tool suite workspace and make sure that the build path of the project contains all the above mentioned jar files and libraries. If not, you can add them manually from your directory.

4. Deploy the project on tomcat server in STS to run the project.

Database Connectivity for MYSQL:-

To set up the connectivity user should have MySQL Connector to the Java (JAR file), the ‘JAR’ file must be in classpath while compiling and running the code of JDBC. Next we'll have to write code
in the src folder we have to do following,

Driver class: Driver class for connectivity of MySQL database “com.mysql.cj.jdbc.Driver”, after the driver has been registered, we can obtain a Connection instance that is connected to a particular database by 
calling DriverManager.getConnection():, in this method, we need to pass URL for connection and name and password of the database.

URL for Connection:- The connection URL for the mysql database is jdbc:mysql://localhost:3306/codefury,"root", "root"

Functionalities of various modules :-

(A) Bean classes

1. User - User class, parent of ProjectManager, Tester and Developer, contains details about all users.
2. Bug - Bug class that stores info about bugs.
3. Project - Project class containing details about the project.
4. Developer - Developer class, child of User, to store data about developers.
5. Project Manager - Project Manager class, child class for User, to store details about project managers.
6. Tester - Tester class, child of User, for details about tester.

(B) Dao layer classes and Interfaces

1. BugTrackDao - Interface for database layer (Dao layer) having function definitions of the layer.
2. BugTrackDaoImpl - This class contains the implementation of the functions defined in the BugTrackDao Interface.
3. DBUtil - provides singleton factory pattern for jdbc.
4. RegisterDao - Interface for registration.
5. RegisterDaoImpl - Implementation of registration.
6. UserDao - Interface for database layer (dao layer).
7. UserDaoImpl - Establish connection with derby db & run queries to fetch/add/modify data.


(C) Exceptions classes

1. BugNotFoundException - Exception when a bug is not found.
2. ErrorInExecutionException - Exception for handling error in execution of code.
3. InvalidUserException - Exception when user is invalid.
4. UserNotFoundException - Exception when the user is not found.

(D) Service layer classes and Interfaces

1. BugTrackService - Interface for business logic layer (service layer).
2. BugTrackServiceImpl - Provide business logic to the bug tracking service.
3. RegisterService - Interface for business logic for registration.
4. RegisterServiceImpl - Provides business logic for registration.
5. UserService - Interface for service layer.
6. UserServiceImpl - class for service layer.

(E) Servlets

1. ImportUsersServlet - For importing users to the database.
2. MyLoginServlet -  servlet for login (session created).
3. LogoutServlet -  To logout of the system (session invalidated).
4. RegisterServlet - For registering a user.
5. AddProject - Adding of new project by manager.
6. PMCreateProject - for starting a new project and navigating to CreateProject.jsp to get the project's information.
7. DisplayPMBugsServlet - To display bug list for the project chosen by the project manager.
8. DisplayPMProjectsServlet - to show the problem list for the project that the project manager has selected.
9. PMAssign - For assigning the developer to a bug.
10. PMCloseBug - For closing the bugs marked by the developers.
11. AddRemarks - When a developer designates a problem as closed, a servlet will add comments.
12. AssignDevServlet - To get the list of developers for assigning them to a bug.
13. DisplayDeveloperBugsServlet - Servlet to display bugs from a specific project.
14. DisplayDeveloperProjectsServlet - To display projects assigned to the developer.
15. DisplayTesterBugsServlet - To display bugs of the project chosen by the tester.
16. DisplayTesterProjectsServlet - To display projects assigned to the tester.
17. GetBugInfoServlet - Used to get info about the new bug from addbug.jsp form.
18. TempBugServlet - to fill in certain information automatically and reroute the page to AddNewBug.jsp.


Database Queries:-

javac -classpath ..\lib\mysql-connector-java-8.0.20.jar;. "BugTrackingProject".

__________________________________________________________________________________

create table usertable (userid int PRIMARY KEY AUTO_INCREMENT, name varchar(25), email varchar(30), type varchar(15));

create table logintable (email varchar(30) primary key, password varchar(20), userid int references usertable(userid));

create table projecttable(projectid int PRIMARY KEY AUTO_INCREMENT, projectname varchar(20),description varchar(40), startdate date, status varchar(15), managerid int);

create table teamtable(projectid int references projecttable(projectid),userid int references usertable(userid), managerid int references usertable(userid));

create table bugtable (uniqueid int PRIMARY KEY AUTO_INCREMENT, title varchar(20),description varchar(40), projectid int references projecttable(projectid), createdby int, opendate date,assignedto int, markedforclosing varchar(6), closedby int,closedon date, status varchar(10),severitylevel varchar(10));
