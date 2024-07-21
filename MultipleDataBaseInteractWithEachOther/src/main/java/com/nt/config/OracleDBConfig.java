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
@EnableJpaRepositories(basePackages = "com.nt.repo.prod",
                             entityManagerFactoryRef = "oracleEMF",   //collected from @Bean method
                             transactionManagerRef = "oracleTxMgmr")   //collected from @Bean method
public class OracleDBConfig {

	//Gives Datasource object as spring bean pointing to oracle jdbc con pool
	@Bean
	@ConfigurationProperties(prefix = "oracle.datasource")
//	@Primary
	public DataSource createOracleDs() {
		return DataSourceBuilder.create().build();
	}
	@Bean(name = "oracleEMF")
//	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleFactoryBeanManager(EntityManagerFactoryBuilder builder) {
		//create map object having hibernate properties
		Map<String,Object> props=new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		// create and return LocalContainerEntityManagerFactoryBean object ehich makes
		//EntityManagerFactory as spring Bean
		return builder.dataSource(createOracleDs())   // datasource
				.packages("com.nt.model.prod")
				.properties(props)     //
				.build();	
		
	}
	
	@Bean(name = "oracleTxMgmr")
//	@Primary
	public PlatformTransactionManager createOracleTxMgmr(
			@Qualifier("oracleEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager();		
	}	
}
