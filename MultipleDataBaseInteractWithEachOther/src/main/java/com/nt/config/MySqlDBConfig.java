package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repo.promotion",
                             entityManagerFactoryRef = "mySqlEMF",   //collected from @Bean method
                             transactionManagerRef = "mySqlTxMgmr")   //collected from @Bean method
public class MySqlDBConfig {

	//Gives Datasource object as spring bean pointing to mysql jdbc con pool
	@Bean
	@ConfigurationProperties(prefix = "mysql.datasource")
	@Primary
	public DataSource createMySqlDs() {
		return DataSourceBuilder.create().build();
	}
	@Bean(name = "mySqlEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createMySqlFactoryBeanManager(EntityManagerFactoryBuilder builder) {
		//create map object having hibernate properties
		Map<String,Object> props=new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		// create and return LocalContainerEntityManagerFactoryBean object which makes
		//EntityManagerFactory as spring Bean
		return builder.dataSource(createMySqlDs())   // datasource
				.packages("com.nt.model.promotion") // model class config
				.properties(props)     // hibernate properties
				.build();	
		
	}
	
	@Bean(name = "mySqlTxMgmr")
	@Primary
	public PlatformTransactionManager createMySqlTxMgmr(
			@Qualifier("mySqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager();		
	}	
}
