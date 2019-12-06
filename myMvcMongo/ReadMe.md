--------------Eureka client--------------------------
read red notebook page 9 aban
Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating
 services for the purpose of load balancing and failover of middle-tier servers. We call this service, the Eureka Server.
  Eureka also comes with a Java-based client component, the Eureka Client, which makes interactions with the service 
  much easier. The client also has a built-in load balancer that does basic round-robin load balancing. 
  A Eureka client application is referred to as an instance

for being eureka client:
- just dependency+set name for app is enough
- if we want to set sth but default, use
@EnableDiscoveryClient
application.properties
note: eureka server just shows registered services, when we stop the registered service, it is not removed from service lists until 
we restart eureka server. 


----------------spring boot test----------------------
The spring-boot-starter-test “Starter” (in the test scope) contains the following provided libraries:

JUnit 4: The de-facto standard for unit testing Java applications.
Spring Test & Spring Boot Test: Utilities and integration test support for Spring Boot applications.
AssertJ: A fluent assertion library.
Hamcrest: A library of matcher objects (also known as constraints or predicates).
Mockito: A Java mocking framework.
JSONassert: An assertion library for JSON.
JsonPath: XPath for JSON.


@SpringBootTest : (first of class test to auto config spring) By default, @SpringBootTest does not start the server. this annotation loads
all beans in spring context. if we nee to just test web layer, it is no need to inject all beans in context.
@RunWith(SpringRunner.class) : (first of class test)
@AutoConfigureMockMvc or @AutoConfigureWebTestClient  :If you have web endpoints that you want to test 
@MockBean : can be used to define a Mockito mock for a bean inside your ApplicationContext (we define results for that bean)
@InjectMocks : the Above @MockBean s inject in the bean under this annotation. it should has the same field names
it can help to test

to test web layer, there is 2 ways:
1- @SpringBootTest
   @AutoConfigureMockMvc
or
2- @WebMvcTest(UserController.class)
in first way, all spring application context loads while in second way just UserController bean injects in context and we use
mock for other layers.

to test repo layer, there is 2 ways:
RepoIntegrationTest1- @SpringBootTest 
or 
RepoIntegrationTest2- @DataMongoTest , ... : It is not completed

@DataJpaTest is used to test JPA repositories. It is used in combination with @RunWith(SpringRunner.class). 
The annotation disables full auto-configuration and applies only configuration relevant to JPA tests. 
By default, tests annotated with @DataJpaTest use an embedded in-memory database.
@DataJPATest(@DataMongoTest,DataJDBCTest,...) by default will begin a new transaction before and roll back it after running a test method.
 to implement integration test of the JPA and Hibernate data layer in Spring Boot
 it needs following dependency:
 <dependency>  
     <groupId>org.hsqldb</groupId>
     <artifactId>hsqldb</artifactId>
     <scope>test</scope>
 </dependency>  