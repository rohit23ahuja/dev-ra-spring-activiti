package dev.ra.sa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class ApplicationConfig {


    @Bean
    public DataSource createDataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.microsoft.sqlserver.jdbc.SQLServerDriver.class);
        dataSource.setUrl("jdbc:sqlserver://MCCDEVDB;instanceName=DMGBSQL01;databaseName=MCCAPP");
        dataSource.setUsername("app-console-mccapp");
        dataSource.setPassword("LondonTown$2013");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
