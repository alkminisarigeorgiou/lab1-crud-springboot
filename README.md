# 🚀 Mars Space Station Resource Management 🚀

## CRUD + CI/CD Implementation Project
### 1st Lab Assignment of the "Software Engineering in Practice" Course 
####  Dept.Management Science and Technology

### 🛠️ Built Using:
* Maven: 3.9.9
* Java: 17

### Running the app locally:
* Clone
* Maven build: `mvn clean package`
* Run: `java -jar target/mars-crud-0.0.1-SNAPSHOT.jar`
* Application: http://localhost:8080/resources

### Running the app using Docker:

* Build image: `docker build -t mars_crud:latest .`
* Run:         `docker run -p 8080:8080 resources:latest`
* Application: http://localhost:8080/resources