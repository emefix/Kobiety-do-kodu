# Kobiety-do-kodu
Kurs javy autorstwa kobietydokodu.pl.

_____________________________________________________
Lesson #00:

Object Oriented Programming JAVA (OOP).
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
The CatShelter class contents the collection of the Cat objects. Creating the Cat objects follow using the GettingCatFromUser class in which datas of the Cat object are getting from user.  
_____________________________________________________
Lesson #05:

Collections in Java. 
Modified the CatShelter class, created the addCat() method which adds the new cat to the List collection of the cats. In the main method of the CatsApp class cats objects are created and they are added to the CatShelter class. 
_____________________________________________________
Lesson #06:

Working with collections. 
Writing the new class describing interface of the application, it's the AppInterface class. Used the JFrame class from javax.swing package. 
The ButtonHandling class implements the interface ActionListener. The AddingCatButtonHandling and ShowCatsButtonHandling objects are created when a user click on the buttons, and their classes inherited from the ButtonHandling class. These classes adding the new cat and showing all cats from the cat shelter, respectively. 
Renamed and modified the GettingCatFromUser class to the GettingDataFromUser in order to this class getting all data from the user. 
_____________________________________________________
Lesson #Lambda expressions and streams:

Creation a new celebrity app.
To assign a lambda expression, we need an interface with the only one method. Such an interface is called a functional interface. 
Functional interface have got the only one method. 
When we use a lambda expression, do not have to create a class implementing an interface.
An anonymous class is created without define a class implements an interface. We do not have to use the CheckIfSinger, CheckIfActor, CheckIfDancer classes implementing the CheckTalent interface. 

The stream represents a sequence of elements and allows to do various operations on them, for example: filter(), sorted(), collect(), forEach(). With these operations, we can: 
select specific items from the collection that interest us; 
sort the collection; 
save the results to a new collection; 
execute commands on its elements. 
To create a stream of any collection, we need to use the stream() method.
_____________________________________________________
Lesson #07: 

Maven project configuration. 
POM file has been modified. 
Modules and needed dependencies were added to break down the application well.

_____________________________________________________
Lesson #08: 

Web application. 
Webapp moduls and needed Spring dependecies have been added. 

_____________________________________________________
Lesson #09: Spring MVC

Configuration of the Spring Web (MVC) framework. The DispatcherServlet is a servlet that dispatches the HTTP requests to controllers and offers other functionality that facilitates the development of web applications, and is declared in the "web.xml" of the web application. 

1. After receiving an HTTP request, DispatcherServlet consults the HandlerMapping to call the appropriate Controller. 
2. The Controller takes the request and calls the appropriate service methods based on used GET or POST method. The service method will set model data based on defined business logic and returns view name to the DispatcherServlet. 
3. The DispatcherServlet will take help from ViewResolver to pickup the defined view for the request. 
4. Once view is finalized, The DispatcherServlet passes the model data to the view which is finally rendered on the browser. 

The web.xml file will be kept in the WebContent/WEB-INF directory of the web application. 
Next, <servlet-mapping> tag indicates what URLs will be handled by which DispatcherServlet. 

The [servlet-name]-servlet.xml file will be used to create the beans defined, overriding the definitions of any beans defined with the same name in the global scope.

The <context:component-scan...> tag will be use to activate Spring MVC annotation scanning capability which allows to make use of annotations like @Controller and @RequestMapping etc.

The InternalResourceViewResolver will have rules defined to resolve the view names. 

The DispatcherServlet delegates the request to the controllers to execute the functionality specific to it. The @Controller annotation indicates that a particular class serves the role of a controller. The @RequestMapping annotation is used to map a URL to either an entire class or a particular handler method.

-> https://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm

