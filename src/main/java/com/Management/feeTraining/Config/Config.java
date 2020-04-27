package com.Management.feeTraining.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class Config {

    @Value("${db.driver}")
    private String Driver_Class_Name;

    @Value("${db.url}")
    private String URL;

    @Value("${db.username}")
    private String USERNAME;

    @Value("${db.password}")
    private String PASSWORD;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${entitymanager.packagesToScan}")
    private String PACKAGES_TO_SCAN;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sfb=new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource());
        sfb.setPackagesToScan(PACKAGES_TO_SCAN);
        Properties hibernateProperties=new Properties();
        hibernateProperties.put("hibernate.dialect",HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show-sql",HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto",HIBERNATE_HBM2DDL_AUTO);
        sfb.setHibernateProperties(hibernateProperties);
        return sfb;


    }
     @Bean
    public DataSource dataSource() {
         DriverManagerDataSource dataSource=new DriverManagerDataSource(URL,USERNAME,PASSWORD);
         dataSource.setDriverClassName(Driver_Class_Name);
         return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }


}
