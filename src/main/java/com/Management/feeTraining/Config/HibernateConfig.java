//package com.Management.feeTraining.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//public class HibernateConfig {
//
//
//
//        @Autowired
//        Environment environment;
//        @Bean(value = "entityManagerFactory")
//        public LocalSessionFactoryBean sessionFactoryBean(){
//
//            LocalSessionFactoryBean sfb=new LocalSessionFactoryBean();
//            sfb.setDataSource(dataSource());
//            sfb.setPackagesToScan(environment.getProperty("packagesToScan"));
//            sfb.setHibernateProperties(hibernateProperties());
//            return sfb;
//
//
//        }
//
//        @Bean
//        public DataSource dataSource() {
//            DriverManagerDataSource ds=new DriverManagerDataSource();
//            ds.setDriverClassName(environment.getProperty("datasource.driver-class-name"));
//            ds.setUrl(environment.getProperty("datasource.url"));
//            ds.setUsername(environment.getProperty("datasource.username"));
//            ds.setPassword(environment.getProperty("datasource.password"));
//            return ds;
//
//        }
//
//        private Properties hibernateProperties() {
//            Properties hibernate = new Properties();
//            hibernate.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//            hibernate.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//            hibernate.setProperty("hibernate.show-sql", environment.getProperty("hibernate.show-sql"));
//            hibernate.setProperty("hibernate.allow_update_outside_transaction", "true");
//            return hibernate;
//
//
//        }
//    }
//
