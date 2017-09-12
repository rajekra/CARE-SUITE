package com.icare.ing.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.icare.common.bootstrap.AppConfig;


/**
 * Created by achat1 on 9/22/15.
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages={"com.icare.ing.*"})
@Import({ AppConfig.class})
public class IngestionConfiguration {

    @Autowired
    private Environment env;

    @Value("${app.name:jigsaw}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri:local}")
    private String masterUri;

    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
              //  .setSparkHome(sparkHome)
                .setMaster(masterUri)
                .set("spark.driver.allowMultipleContexts", "true");;

        return sparkConf;
    }

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .sparkContext(javaSparkContext().sc())
                .appName("Java Spark SQL basic example")
                .getOrCreate();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    

    @Value("${phoenixUrl}")
    private String phoenixUrl;
    	    
	
	@Bean
	public BasicDataSource phoenixDataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
		basicDataSource.setUrl(phoenixUrl);
		return basicDataSource;
	}
	
	@Bean
	public JdbcTemplate phoenixJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(phoenixDataSource());
		return jdbcTemplate;
	}
	
//	  @Bean
//	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//	 
//	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	      em.setJpaVendorAdapter(vendorAdapter);
//	    //  em.setJpaProperties(additionalProperties());
//	 
//	      return em;
//	   }
//	  
//	  Properties additionalProperties() {
//	      Properties properties = new Properties();
//	     // properties.setProperty("hibernate.hbm2ddl.auto", "validate");
//	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//	      properties.setProperty("hibernate.showsql", "true");
//	      properties.setProperty("hibernate.format_sql", "true");
//	      properties.setProperty("hibernate.use_sql_comments", "true");
//	      return properties;
//	   }
//	
//	 @Bean
//	    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//	         HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
//	         factory.setEntityManagerFactory(emf);
//	         return factory;
//	    }
}