Folder Structure:-

	1 - vehicles-config-service (Cloud Config Server)
	2 - vehicles-config-service/config-repo (Configuration files Repository)
		vehicles-config-service/config-repo.zip (Compressed Version)
	3 - vehicles-dashboard (Frontend, Angualar 4 App)
	4 -	vehicles-dashboard.zip (cmpressed version of the frontend app so i can upload it on github)
	5 - vehicles-discovery-server (Cloud Discovery Eureka Server)
	6 - vehicles-gateway-service (Cloud Routing ZUUL)
	7 - vehicles-service (customer databse and api)
	8 - vehicles-status-service (Car Simulation Service)
	9 - Full architectural sketch (image for solution design)
	10 - customers-api (screenshot for customer api response)
	11 - vehicle-status-api (screenshot for vehicle status api)
	12 - Full architectural sketch (screenshot for the frontend app)
	13 - read me file for the documentation
	14 - jars (contains jars for all the services in case you want to run them directly from your CMD)
	
	- inside every folder you will find docker file in case you want to run them inside docker
	

Technology Stack:-
	
	this task developed using (JAVA & Spring boot)
	
	1 - Cloud Config Server: 
		Central management for configuration via a git or svn backend.
	
	2 - Cloud Config Client:
		spring-cloud-config Client
		
	3 - Cloud Discovery (Eureka Discovery Server & Client):
		Service discovery using spring-cloud-netflix and Eureka
		
	4 - Cloud Routing (ZUUL):
		Intelligent and programmable routing with spring-cloud-netflix Zuul
		
	5 - Ribbon:
		Client side load balancing with spring-cloud-netflix and Ribbon
	
	6 - Feign:
		Declarative REST clients with spring-cloud-netflix Feign
		
	7 - Cloud Circuit Breaker (Hystrix):
		Circuit breaker with spring-cloud-netflix Hystrix
		
	8 - H2:
		H2 database (with embedded support)
	
	9 - Spring Web:
		Full-stack web development with Tomcat and Spring MVC
		
	10 - Angular 4:
		a Structural Javascript Framework for Dynamic Web Apps
	

Deployment Steps:-

	- the services is configerd to run on localhost if you changed the ip for the gateway-service or discovery service you must change the configurations.
	- if you need to change the configration you must do it in config-repo folder under your home directory becasue the config service reads from this folder.
	- if you made any changes in config-repo you must commit your changes becuase it's a git repository.
	
	* Please follow below steps:-
		1 - copy (vehicles-config-service/config-repo) folder under your user home directory.
		2 - start discovery server
		3 - start config server
		4 - start the rest of the services
		5 - after you start all the services give it some time before you try it, the discovery server takes about 40s to configure every thing
			so if you made a request and got error page please give it some time and try again 
		6 - start the frontend app	
			- i have configured the vehiclee status to refresh every 10 secondes instead of one minute to speed things up for this demonstration 
	
	* Commands:-
		- you can run the jar for any service using (java -jar "jar name"), you must be inside jars directory
		- you can run the angular app using (ng serve), you must be inside vehicles-dashboard directory
		
		
Url's:-

	1 - http://localhost:8765/api/vs/getAllCustomers (return list of customers and their vehicles)
	2 - http://localhost:8765/api/vs/getVehicleStatus/YS2R4X20005387055 (takes vehicle id and return it's status)
	3 - http://localhost:4200/  (dashboard url)
	4 - http://localhost:8761/  (Eureka Dashboard)










