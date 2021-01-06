# springboot-rest-mybatis
Springboot project with rest and mybatis support

Import the project as maven project.

Run the DemoApplication.java file as the main class

Hit the end point: 
	
	http://localhost:8080/init: This will intialize the data
 
After this muliple endpoints are available:

	GET: http://localhost:8080/employees : return all the employees
	GET: http://localhost:8080/employees/10011 : returns the employee with id 10011
	POST: http://localhost:8080/employees with body in json form: {"id":10011,"firstName":null,"lastName":null,"emailId":null} will insert the value

Database used: H2

	Persistance framework used: Mybatis
