package com.musicBackend.musicBackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MusicBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicBackendApplication.class, args);
	}


//	@Bean
//	public IntegrationDataSourceScriptDatabaseInitializer customIntegrationDataSourceInitializer(DataSource dataSource) {
//		return new IntegrationDataSourceScriptDatabaseInitializer(dataSource, new DatabaseInitializationSettings());
//	}
}
