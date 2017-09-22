
# Anypoint Template: API Led Connectivity API for customer

+ [Use Case](#usecase)
+ [Considerations](#considerations)
+ [Run it!](#runit)
	* [Properties to be configured (With examples)](#propertiestobeconfigured)
+ [Customize It!](#customizeit)
+ [Include common library files](#commonLibraryFiles)

# Use Case <a name="usecase"/>

This Anypoint Template is a REST API implemented using APIkit and RAML definition. The basic CRUD operations are implemented for Account object. The API uses JSON as an exchange format. Included are example requests and responses.
This Anypoint Template should serve as a foundation for API Led Connectivity approach of running an enterprise. Every new project developed at Hertz should download the template from exchange and rename the project to implementation application name

### Templates uses Customer Account as an use case
Below are the endpoints that are implemented.

### GET /customer
Retrieves customer from customer SOR based on the combination of query parameters. `last name` should be set to retrieve results. Look at the included RAML definition to learn more about the implemented query parameters.

### POST /customer
Add or create a new customer

### GET /customer/{id}
Retrieves an Customer based on the given native identifier .

### PUT /customer/{id}
Updates an Customer with the data in the HTTP request. All fields are overwritten.

### POST /creditCard
Add a new Credit Card

### GET /creditCard/{id}
Get credit card using Id (creditCard.id = {id})

### PUT /creditCard/{id}
Updates an existing credit card object with the data in the HTTP request. All fields are overwritten.


Look at the included self-descriptive RAML definition and the corresponding flows to learn more about the application.

# Considerations <a name="considerations"/>

To make this Anypoint Template run, there are certain preconditions that must be considered. All of them deal with the preparations, that must be made in order for all to run smoothly.
**Failling to do so could lead to unexpected behavior of the template.**

### Where to Download Mule Studio
First thing to know if you are a newcomer to Mule is where to get the tools.

+ You can download Mule Studio from this [Location](https://www.mulesoft.com/platform/studio)
+ use studio preference -> anypoint platform for API to pair studio with cloudhub

### Importing an Anypoint Template into Studio
Mule Studio offers several ways to create project from template using studio: 

+ New project from template
+ Login and go to Hertz global 
+ select template-hertz-api-led

### Running on Studio <a name="runonstudio"/>
Once you have imported Anypoint Template into Anypoint Studio you need to follow these steps to run it:

+ rename the project (template-hertz-api-led) to your application name
+ Locate the properties file name `template-hertz-api-led-${mule-env}.properties`, in src/main/resources/env and rename the properties to application name 
+ Fill out all the properties required as per the examples in the property files provided
+ run mvn install to install auditing-framework and common-error customer external jar to the build path and rebuild project
+ Once that is done, right click on you Anypoint project folder 
+ Hover you mouse over `"Run as"`
+ Click on  `"Mule Application"`

## Properties to be configured (With examples) <a name="propertiestobeconfigured"/>
In order to use this Mule Anypoint Template you need to configure properties (Credentials, configurations, etc.) either in properties file or in CloudHub as Environment Variables. Detail list with examples:


### Application configuration
**Common configuration**

+ https.port `8092`
+ property.key -  Key used to encrypt / decrypt property files. Update the default value provided with the Hertz generic password
		
**API configuration**

+ api.domain `<app-name>.cloudhub.io`
+ api.basePath `/api/*`
+ api-autodiscovery-name=sandbox-template-hertz-api-led
+ api-autodiscovery-version=1.0


# Customize It!<a name="customizeit"/>
This brief guide intends to give a high level idea of how this Anypoint Template is built and how you can change it according to your needs.
As mule applications are based on XML files, this page will be organized by describing all the XML that conform the Anypoint Template.
Of course more files will be found such as Test Classes and [Mule Application Files](http://www.mulesoft.org/documentation/display/current/Application+Format), but to keep it simple we will focus on the XMLs.

Here is a list of the main XML files you'll find in this application:

* [api.xml] - api mapping
* [common-config.xml] - common configuration to store all global elements
* [credit-card.xml] - credit card 
* [customer.xml] - customer

# Update POM file to include common library<a name="commonLibraryFiles"/>

Step1:  Include Parent pom

	<parent>
		<groupId>com.hertz.mule</groupId>
		<artifactId>parent-pom</artifactId>
		<version>1.1</version>
	</parent>
	
Step2:  Add common dependencies without version

	<dependency>
			<groupId>com.hertz.mule</groupId>
			<artifactId>common-error</artifactId>
	</dependency>
		<dependency>
			<groupId>com.hertz.mule</groupId>
			<artifactId>common-utils</artifactId>
		</dependency>

Step3:  Remove all repositories

Step4: Spring import
 
	<spring:beans>
        <spring:import resource="classpath:common-error.xml"/>
        <spring:import resource="classpath:common-utils.xml"/>
    </spring:beans>


