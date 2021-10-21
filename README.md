Spring 
------------------------------------------------------------------

    Pre-Requisite Knowledge
    -------------------------------------------------------
        Spring Core (IoC/DI)                        
        Spring Context
                            BeanFactory vs ApplicationContext
                            Annotation Based Configuaration
                            Java Based Configuaration
                                        @Component
                                            @Controller
                                            @Service
                                            @Repository
                                            @Resource
                                            ..etc
                                        @AutoWired
                                        @Qualifier
                                        @Primary
                                        @Required
                                        @Scope
                                        @Value
                                        @Configuaration
                                        @ComponentScan
                                        @ProeprtySource
                                        @Bean

        Spring SpEL (Spring Expression Language)    
        Spring AOP (Aspect Oriented Programming)
        JPA / Hibernate   
            @Entity
            @Table
            @Id
            @GeneratedValue
            @OnetTOOne
            @OneToMany
            @ManyToOne
            @M<anyToMany
            @Inheretence
            @DiscriminatorValue

            Entity Life Cycle & states

            JPA EntityManger api / Hibernate Session and SessionFactory

            Fetch Strategies
            Cacading Strategies

    Spring Boot
    -------------------------------------------------------

        Coverage 
            Spring Boot Fundamentals
            REST Fundamentals
            Components of RESTful Web Services
            Spring Boot CLI and Initializing a Spring Boot Project
            Developing Web Applications using REST End Points with Spring Boot in Spring MVC
            Externalized Configurations
            Spring Boot Actuator
            Testing the Spring Boot Project
            Spring Boot Developer Tools

            Spring Data JPA
            Spring Data REST

    Lab Setup
    ------------------------------------

        JDK 1.8
        Spring Tool Suite latest
        MySQL

    Spring Core and Context and SpEl
    --------------------------------------------------------------------------------------------

        DI / IoC

            IoC     is an idea

                    - Decompose our appliction into independent isolated interactive components.
                    - Parellel skeleton or framework that plays the role of CONDUCTOR,
                        is th one who keeps track of all the lsited Components and 
                        supplies them to the mail flow of execution when each of them is needed.

            Dependecy Injection is a concept of achving IoC....

                Object of a Component is called a BEAN

                - Setter Injection
                - Field Injection
                - Cosntructor Injection
                - Method Injection

            ApplicationContext          is also called the bean container.

                a container is the one who manages the life cycle of a bean,
                    creating a bean
                    suppling a bean
                    destroying bean

                ClassPathXmlApplciationContext
                AnnotationApplicationContext
                ...etc

                Bean Configuaration
                    - informing the contaienr 
                        () how many bean needed?
                        () how are they dependent?
                        () how many of them are needed?

                Xml Based Configuaration
                Annotation Based Configuaration
                    @Configuaration
                    @ComponentScan({"basePackage1","bsePackage2..."})
                    @PropertySource("")
                    @Component("id")
                        @Service
                        @Repository
                        @Resource
                        @Controller
                        @RestController
                        @Advice
                        @ControllerAdvice
                        @RestControllerAdvice
                        .....etc
                    @value
                    @Autowired
                    @Primary
                    @Qualifier
                    @Scope                  singleton/prototype/request/session/global-session

                                @Component
                                class MyComp {
                                    @Autowired              //field injection
                                    private Service1 obj;
                                }

                                @Component
                                class MyComp {
                                 
                                    private Service1 obj;

                                    @Autowired                  //constructor injection
                                    public MyComp(Sercice1 obj){
                                        this.obj=obj;
                                    }
                                }

                                @Component
                                class MyComp {
                                 
                                    private Service1 obj;

                                    @Autowired                     //setter injection
                                    public void setObj(Service1 obj){
                                        this.obj=obj;
                                    }
                                }

                        annottion based configuaration can not be used
                        to register thrid party or in-built classes as components.

                Java Based Configuaration

                        @Configuaration
                        class MyConfig{

                            @Bean
                            public ClassName beanId(){
                                return new ClassName();
                            }
                        }

    Spring Boot
    ------------------------------------------------------------------------------------

        is a RAD module of spring framework.

            Rapid Appliction Development

                Spring Web MVC
                    Configure all paths to DispatcherServlet
                    Configure the view engine (JSP / Thymeleaf)
                    Configure the internal resource view resiolver
                    ...etc

                Spring Security
                    Configure the basic security dependency
                    Configure the authentication type
                    Configure the authentication source ...etc

                Spring Data
                    Configure the database related properties
                    Configure the JPA implementation (Hibernate / ibates /..)
                    Configure the Spring and hibernate validation framework
                    ...etc

            if we use Spring boot along with these modules, the
            configuaration drop to minimum. As spring boot enables
            AutoConfiguaration.

            1. AutoConfiguaration that enables RAD
            2. Embeded Servers thsi enables Serverless applications suitable for containerization.

            a. Use Spring Initializer http://start.spring.io
            b. Use Spring Starter Project option from STS
            c. Use Spring CLI
                    spring-boot init

            @SpringBootApplication = @Configuration
                                    @AutoConfiguration
                                    @ProeprtySource
                                    @ComponentScan

    Spring Web MVC on Spring Boot
    ----------------------------------------------------------------

            Multi-Layer Archetecture        SOLID

                PersistenceUnit <--> [ DAO -----(DTO)-------- SERVICE -------(DTO)-------- UI ] <-->  End User
                 (FS/Ddatabase)         Persistence Logic   Bussienss Logic     Presentation Logic

            Model View Controller Archetecture

    PersistenceUnit <--> [ Repostory ---(model)--- SERVICE ---(model)--- Controller --(model)-- View ] <-->  End User
    (FS/Ddatabase)         Persistence Logic   Bussienss Logic              Flow Logic      Presentation Logic


            Single Front Controller Desgin Pattern (MVC)

                Repo1           Service1            Controller1
    PU  <---->  Repo2   <-M->   Service2    <-M-->  Controller2    <----- FrontController      <-----REQ
                Repo3           Service3            Controller3     viewName-->
                                                                             |
                                                                             | (model)
                                                                             |
                                                                            VIEWS ----------RESP------------->

        Spring Web MVC

                FrontController?        DispatcherServlet       /*  
                Controller?             is any POJO that is marked with @Controller
                                        these controller must have method to handle an incoming request,
                                        and those methods are called request handlers or actions

                                            Each action must return 
                                                1. a view name as String  or 
                                                2. ModelAndView cotaining a view name and model.

                How can FrontController know to which action of which controller shall
                an incoming request be passed to??

                            UrlHandlerMapping
                                BeanNameUrlHandlerMapping
                                SimpleUrlHandlerMapping     (default)
                                    @RequestMapping(value="url",method=Method.(POST/GET..))
                                    on the controller and ont eh action method.

                How does a view is selected based on the view name given 
                by the action method??

                            ViewResolver
                                XmlResourceViewResolver     .xml (viewname and actual view paths)
                                MessageBundleResourceViewResolver .properties (viewname and actual view paths)
                                InternalResourceViewResolver (default)

                                    actual view path = prefix + viewname + suffix


                @Controller
                @RequestMapping(value="",method=Method.GET)
                    @GetMapping
                    @PostMapping
                    @PutMapping ...etc
                                        HTTP Methods
                                            GET
                                            POST

                @RequestParam           QueryString     /editEmp?empId=1
                @PathVariable           PathParameters  /editEmp/1
                @ModelAttribute
                @SessionAttribute

                Assignemnt
                --------------------
                    Employee
                        empId : Long
                        fullName: String
                        basic: Double
                        joinDate: LocalDate
                        ta: Double  //5% of Basic 
                        hra: Double //7% of the Basic
                        grossPay: Double
                        tds: Double //10% of grossPay
                        netPay: Double 
                        experience: Integer //years between joinDate and currentDate
                
                Assignemnt
                ---------------------------
                    Item
                        icode
                        name
                        unit        PACK/KG/Liter...
                        rate
                        category    BEVERAGE/PULSES/CERALS/FARM...

                    ItemController

                        addItem         accept an item from a form and add it to a 'List<Items> stock'
                                        and display all of the itmes in 'items-page'

                        removeItem       accept an item code and delete it from 'List<Items> stock'
                                        and display all of the itmes in 'items-page'

                            Where 'List<Items> stock' must be maintaiend in a session.


    Spring Data with Spring Web on Spring Boot
    -----------------------------------------------------------

        Spring Data is a spring module that can
        generate the DAO implementations (Repositories) dynamically
        from a mapped entity.

        JpaRepository       @Repository

                boolean existsByFieldName(Type fieldName)
                Entity findByFieldName(Type fieldName)
                List<Entity>  findAllByFieldName(Type fieldName)

                @Query("jpql")
                method signature.....



    Spring Server Side Validations (hibernate-validator library)
    -------------------------------------------------------------

        @NotNull
        @NotEmpty
        @NotBlank
        @Min
        @Max
        @Size
        @Pattern
        @PastDate
        @FutureDate
        ...etc
          
                Assignemnt
                ---------------------------
                    Item
                        icode
                        name
                        unit        PACK/KG/Liter...
                        rate
                        category    BEVERAGE/PULSES/CERALS/FARM...

                    ItemController

                      to perform all CRUD Operatons upon the above entity.
                      using Spring Data and with validations.

    Spring Rest on Spring Boot
    ----------------------------------------------------------------

        Muti-Faced Apps
        --------------------
                                                    Web App                 <---> Users
           Database <-->  WebServices   <--->       Standalone GUI App      <---> Users
                                                    Mobile App              <---> Users
                                                        Andriod App
                                                        IOS App ...etc.,

            WebServices
                SOAP    (Simple Object Access Protocol)     XML as medium of communication

                    - Standard Set for sharing and creating End points (URLS)
                    - We can not share or publish binary data like iamges/binary files ..etc
                    - No proper error propagation system

                HTTP    Based WebServices   REST api
                                            Representational state transfer

                    + http protocol already supports any sort of data sharing text/xml/binary/graphics..etc
                                text        JSON
                                text        XML
                                bianry      images/binary files

                    + a standard communcation set up can be made as below

                        1. Http Status codes can be used for error propagation
                                1xx         confirm the reception of a req and states that the req is being processed
                                2xx         confirm the succesful completion of the reqeust
                                3xx         confirm a request redirection
                                4xx         inform that the reqeust can not be process due to client side issue
                                5xx         inform that the reqeust can not be process due to server side issue

                        2. Http Methods can be used to represent an operation on a singel end poitn per entity

                            GET     /emps          /depts              retrive all emps or depts
                            GET     /emps/{empid}  /depts/{deptId}     retrive a record for the given id        
                            POST    /emps          /depts              insert
                            PUT     /emps          /depts              Full record Update 
                            PATCH   /emps          /depts              Partial Update 
                            DELETE  /emps          /depts              delete

                        JAX-rs
                        Spring REST ..etc

                        Spring REST
                                @RestController     =  @Controller @ResposneBody 
                                    actions in a restcontroler returns ResponseEntity (responseBody,httpStatus)
                                
                                @RequestBody

                        REST Client
                            Postman
                            Insomnia ..etc

                Assignemnt
                ---------------------------
                    Item
                        icode
                        name
                        unit        PACK/KG/Liter...
                        rate
                        category    BEVERAGE/PULSES/CERALS/FARM...

                    ItemRepo    <------- JpaRepository

                        + a method to check if an item with a specific unit exists or not
                        + a method to check if an item with a specific category exists or not
                        + a method to retrive all item for a givne category
                        + a method to retrive all item having rate in a given range
                
                    ItemRestController

                      to perform all CRUD Operatons upon the above entity.
                      using Spring Data and with validations.and retrival operatons as well.


           Database <-->               REST API          <-RestTemplate->     Web MVC App             <---> Users

                        Spring Data + Spring REST on Spring Boot      Spring Web MVC on Spring Boot

                Assignemnt
                ---------------------------
                Part 1: Create a Spring REST App on Spring boot as below
                    Item
                        icode
                        name
                        unit        PACK/KG/Liter...
                        rate
                        category    BEVERAGE/PULSES/CERALS/FARM...

                    ItemRepo    <------- JpaRepository

                        + a method to check if an item with a specific unit exists or not
                        + a method to check if an item with a specific category exists or not
                        + a method to retrive all item for a givne category
                        + a method to retrive all item having rate in a given range
                
                    ItemRestController

                      to perform all CRUD Operatons upon the above entity.
                      using Spring Data and with validations.and retrival operatons as well.
                
                Part 2: Create a Spring Web MVC App on Spring boot as below to consume
                        the rest endpoints created in Part 1.

    Spring Boot - Externalized Configuaration
    ----------------------------------------------------------------

        application.properties      holds all externalizable property value that can be
                                    accessed using @Value  Field injector.

        application-test.properties      
                                    holds all externalizable property value that can be
                                    accessed using @Value  Field injector while testing.
                                    and must be configured using @TestProeprtySource

        https://docs.spring.io/spring-boot/docs/2.0.6.RELEASE/reference/html/boot-features-external-config.html

    Spring Boot - Actuator
    ----------------------------------------------------------------

        Actuator is mainly used to expose operational information about the running application — health, metrics, info, dump, env, etc. It uses HTTP endpoints or JMX beans to enable us to interact with it.

        Monitoring our app, gathering metrics, understanding traffic..etc.,.

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        Enable all endpoints
            management.endpoints.web.exposure.include=*

        Enable a specific endpoint
            management.endpoint.beans.enabled=true

        After enabling all endpoint a specific endpoint can be disabled as
            management.endpoints.web.exposure.exclude=loggers

        Exposed Endpoints

        /actuator

            /auditevents lists security audit-related events such as user login/logout. Also, we can filter by principal or type among other fields.

            /beans returns all available beans in our BeanFactory. Unlike /auditevents, it doesn't support filtering.
            /conditions, formerly known as /autoconfig, builds a report of conditions around autoconfiguration.
            /configprops allows us to fetch all @ConfigurationProperties beans.
            /env returns the current environment properties. Additionally, we can retrieve single properties.
            /flyway provides details about our Flyway database migrations.
            /health summarizes the health status of our application.
            /heapdump builds and returns a heap dump from the JVM used by our application.
            /info returns general information. It might be custom data, build information or details about the latest commit.
            /liquibase behaves like /flyway but for Liquibase.
            /logfile returns ordinary application logs.
            /loggers enables us to query and modify the logging level of our application.
            /metrics details metrics of our application. This might include generic metrics as well as custom ones.
            /scheduledtasks provides details about every scheduled task within our application.
            /sessions lists HTTP sessions given we are using Spring Session.
            /shutdown performs a graceful shutdown of the application.
            /threaddump dumps the thread information of the underlying JVM.

    Spring Boot DevTools
    ------------------------------------------------------------------------------

    <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-devtools</artifactId>  
        <scope>runtime<scope >  
    </dependency>  

    Property Defaults
    Automatic Restart
    LiveReload
    
    Spring Boot Testing
    ------------------------------------------------------------------------------

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>test</scope>
        </dependency>

        spring.datasource.url = jdbc:h2:mem:test
        spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.H2Dialect


    Integration Testing - No Mocks
    ------------------------------------
       @ExtendWith(SpringExtension.class)
        @SpringBootTest(
        SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
        @AutoConfigureMockMvc
        @TestPropertySource(locations = "classpath:application-integrationtest.properties")
        public class EmployeeRestControllerIntegrationTest {

            @Autowired
            private MockMvc mvc;

            @Autowired
            private EmployeeRepository repository;

            @Test
            public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

                createTestEmployee("bob");

                mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("bob")));
            }
        }

    Unit testing Service - mocking repo
    -------------------------------------------
    @ExtendWith(SpringExtension.class)
    public class EmployeeServiceImplUnitTest {

        @TestConfiguration
        static class EmployeeServiceImplTestContextConfiguration {
    
            @Bean
            public EmployeeService employeeService() {
                return new EmployeeServiceImpl();
            }
        }

        @Autowired
        private EmployeeService employeeService;

        @MockBean
        private EmployeeRepository employeeRepository;

        @Before
        public void setUp() {
            Employee alex = new Employee("alex");

            Mockito.when(employeeRepository.findByName(alex.getName()))
            .thenReturn(alex);
        }

        @Test
        public void whenValidName_thenEmployeeShouldBeFound() {
            String name = "alex";
            Employee found = employeeService.getEmployeeByName(name);
        
            assertThat(found.getName())
            .isEqualTo(name);
        }
    }

    Unit testing repo
    -------------------------------------------

   @ExtendWith(SpringExtension.class)
    @DataJpaTest
    public class EmployeeRepositoryIntegrationTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private EmployeeRepository employeeRepository;

        @Test
        public void whenFindByName_thenReturnEmployee() {
            // given
            Employee alex = new Employee("alex");
            entityManager.persist(alex);
            entityManager.flush();

            // when
            Employee found = employeeRepository.findByName(alex.getName());

            // then
            assertThat(found.getName())
            .isEqualTo(alex.getName());
        }

    }