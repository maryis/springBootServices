--------------Eureka client--------------------------

for being eureka client:
- just dependency+set name for app is enough
- if we want to set sth but default, use
@EnableDiscoveryClient
application.properties


----------------spring boot test----------------------
The spring-boot-starter-test “Starter” (in the test scope) contains the following provided libraries:

JUnit 4: The de-facto standard for unit testing Java applications.
Spring Test & Spring Boot Test: Utilities and integration test support for Spring Boot applications.
AssertJ: A fluent assertion library.
Hamcrest: A library of matcher objects (also known as constraints or predicates).
Mockito: A Java mocking framework.
JSONassert: An assertion library for JSON.
JsonPath: XPath for JSON.


@SpringBootTest : (first of class test to auto config spring) By default, @SpringBootTest does not start the server. 
@RunWith(SpringRunner.class) : (first of class test)
@AutoConfigureMockMvc or @AutoConfigureWebTestClient  :If you have web endpoints that you want to test 
@MockBean : can be used to define a Mockito mock for a bean inside your ApplicationContext (we define results for that bean)
@InjectMocks : the Above @MockBean s inject in the bean under this annotation. it should has the same field names
it can help to test


@DataJPATest(@DataMongoTest,DataJDBCTest,...) by default will begin a new transaction before and roll back it after running a test method.
it uses an in-mem db
 to implement integration test of the JPA and Hibernate data layer in Spring Boot
 it needs following dependency:
 <dependency>  
     <groupId>org.hsqldb</groupId>
     <artifactId>hsqldb</artifactId>
     <scope>test</scope>
 </dependency>  
