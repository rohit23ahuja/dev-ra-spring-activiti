package dev.ra.sa;

import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ActivitiConfig {

    @Bean
    public DataSource createDataSource(){
        DataSource dataSource = ;
    }

    @Bean
    public SpringProcessEngineConfiguration createProcessEngineConfiguration(DataSource dataSource){
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource);
        return new SpringProcessEngineConfiguration();
    }

    @Bean
    public ProcessEngineFactoryBean createProcessEngine(SpringProcessEngineConfiguration config) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(config);
        return processEngineFactoryBean;
    }
}
