# Kobiety-do-kodu
The java course comes from kobietydokodu.pl.

_____________________________________________________
Lesson #00:

Object-Oriented Programming JAVA (OOP).
More information in the file named "Programowanie obiektowe.docx".
_____________________________________________________
Lesson #01:

Objects in JAVA.
Creation of the Cats package and the Cat class.
_____________________________________________________
Lesson #02:

Interaction with the user.
Creation of the method for getting data from the user.
_____________________________________________________
Lesson #03:

Type conversion, exception handling. 
Modifying the Cats class to handle exceptions when the user input. 
_____________________________________________________
Lesson #04:

Regex - regular expressions. 
Creation of regular expressions corresponding to the date and weight of the Cat class. 
Renamed the Cats class to the CatsApp class. Adding the GettingCatFromUser class and the CatShelter class. 
The CatShelter class contains the collection of the Cat objects. Creating the Cat objects follows using the GettingCatFromUser class in which data of the Cat object are getting from a user.  
_____________________________________________________
Lesson #05:

Collections in Java. 
Modified the CatShelter class, created the addCat() method which adds the new cat to the List collection of the cats. In the main method of the CatsApp class, cat objects are created and they are added to the CatShelter class. 
_____________________________________________________
Lesson #06:

Working with collections. 
Writing the new class describing the interface of the application, it's the AppInterface class. Used the JFrame class from javax.swing package. 
The ButtonHandling class implements the interface ActionListener. The AddingCatButtonHandling and ShowCatsButtonHandling objects are created when a user clicks on the buttons, and their classes are inherited from the ButtonHandling class. These classes adding the new cat and showing all cats from the cat shelter, respectively. 
Renamed and modified the GettingCatFromUser class to the GettingDataFromUser to this class getting all data from the user. 
_____________________________________________________
Lesson #Lambda expressions and streams:

Creation of a new celebrity app.
To assign a lambda expression, we need an interface with only one method. Such an interface is called a functional interface. 
The functional interface has got the only one method. 
When we use a lambda expression, do not have to create a class implementing an interface.
An anonymous class is created without defining a class that implements an interface. We do not have to use the CheckIfSinger, CheckIfActor, CheckIfDancer classes implementing the CheckTalent interface. 

The stream represents a sequence of elements and allows to do various operations on them, for example: filter(), sorted(), collect(), forEach(). With these operations, we can: 
select specific items from the collection that interests us; 
sort the collection; 
save the results to a new collection; 
execute commands on its elements. 
To create a stream of any collection, we need to use the stream() method.
_____________________________________________________
Lesson #07: Maven

Maven project configuration. 
The POM file has been modified. 
Modules and needed dependencies were added to break down the application well.

_____________________________________________________
Lesson #08: Web application

Webapp modules and needed Spring dependencies have been added. 

_____________________________________________________
Lesson #09: Spring MVC

Configuration of the Spring Web (MVC) framework. The DispatcherServlet is a servlet that dispatches the HTTP requests to controllers and offers other functionality that facilitates the development of web applications, and is declared in the "web.xml" of the web application. 

1. After receiving an HTTP request, DispatcherServlet consults the HandlerMapping to call the appropriate Controller. 
2. The Controller takes the request and calls the appropriate service methods based on the used GET or POST method. The service method will set model data based on defined business logic and returns the view name to the DispatcherServlet. 
3. The DispatcherServlet will take help from ViewResolver to pickup the defined view for the request. 
4. Once the view is finalized, The DispatcherServlet passes the model data to the view which is finally rendered on the browser. 

The web.xml file will be kept in the WebContent/WEB-INF directory of the web application. 
Next, the <servlet-mapping> tag indicates what URLs will be handled by which DispatcherServlet. 

The [servlet-name]-servlet.xml file will be used to create the beans defined, overriding the definitions of any beans defined with the same name in the global scope.

The <context:component-scan...> tag will be used to activate Spring MVC annotation scanning capability which allows making use of annotations like @Controller and @RequestMapping etc.

The InternalResourceViewResolver will have rules defined to resolve the view names. 

The DispatcherServlet delegates the request to the controllers to execute the functionality specific to it. The @Controller annotation indicates that a particular class serves the role of a controller. The @RequestMapping annotation is used to map a URL to either an entire class or a particular handler method.

-> https://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm

_____________________________________________________
Lesson #10: Spring MVC - forms and views

Tags use in views and a proper form handling using taglibs of JSTL (Java Standard Tag Library). 
TagLib is a library of tags, that are artifacts. These artifacts we can use in views instead of standard classes. 
The EL (Expression Language) is a standard for expressions and scrips in views and use by ${}. The El can be ignored by isElLIgnored=true.

In the Celebrity app, there is a form of adding a new celebrity. It works with GET and POST requests. This form is validated with @Valid annotation using the Hibernate Validator. To handle the form it is needed a DTO object (data transfer object). The DTO object will be a model attribute with @ModelAttribute annotation of a request method. A BindingResult object checks whether the form was properly verified.

_____________________________________________________
Lesson #11: Database connectivity JDBC

JDBC (Java DataBase Connectivity) is an interface that allows connecting to a database. 
In the Cats app, there was an implementation of database MySQL. We display cat data from the database, add a new cat to the database and display detailed information about a cat. 
A website displays cat data from the database, adds a new cat to the database, and displays detailed information about a cat.

_____________________________________________________
Lesson #12: Database with JPA 

Object-relational mapping (ORM)
An entity is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table. 
In the Celebrity app, there was an implementation of the database MySQL. In the spring-jpa.xml file, there is a configuration of the EntityManager.

_____________________________________________________
Lesson #NoSQL database - Firebase

Firebase cloud storage connectivity in the Cat app. 
Create a project and generate its API in the form of a JSON file, which will have the authorization version.
Next, create cloud storage.
The downloaded file must be opened in the application with the service account class code with the annotation @SERVICE.
The method with the @PostConstruct annotation contained in it will be called immediately after the dependency injection to initialize the database connection.

_____________________________________________________
Lesson #14: Database with Spring Data

The Spring Data is a tool using the JPA, so the EntityManagerFactory is still needed in the Spring configuration file. Creating the I_CelebrityCrudRepository interface extending the Repository<> managed by the Spring Data and marked by the @Repository annotation. And then the using the new repository as a user class field marked by the @Autowired annotation. 