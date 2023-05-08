package dev.ra.sa;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class ActivitiConfig {



    @Bean
    public SpringProcessEngineConfiguration createProcessEngineConfiguration(DataSource dataSource, DataSourceTransactionManager dataSourceTransactionManager){
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setTransactionManager(dataSourceTransactionManager);
springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
springProcessEngineConfiguration.setJobExecutorActivate(false);
        return new SpringProcessEngineConfiguration();
    }

    @Bean
    public ProcessEngineFactoryBean createProcessEngine(SpringProcessEngineConfiguration config) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(config);
        return processEngineFactoryBean;
    }

    @Bean
    public RepositoryService createRepositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    @Bean
    public RuntimeService createRuntimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService createTaskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }

    @Bean
    public HistoryService createHistoryService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    @Bean
    public ManagementService createManagementService(ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }

    @Bean
    public IdentityService createIdentityService(ProcessEngine processEngine) {
        return processEngine.getIdentityService();
    }
}
