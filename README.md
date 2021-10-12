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

                @RequestParam
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
        @FuteureDate
        ...etc