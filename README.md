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
                Java Based Configuaration

                    @Configuaration
                    @ComponentScan({"basePackage1","bsePackage2..."})
                    @PropertySource("")
                    @Component("id")
                    @value
                    @Autowired



