package cabz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cabz.common.PropertyReader;
import cabz.dao.LoginModuleDataAccess;
import cabz.dao.MongoAdminModuleDataAccessImpl;
import cabz.dao.MongoVendorModuleDataAccessImpl;
import cabz.dao.VendorModuleDataAccess;

import com.mongodb.MongoClient;


/**
 * Server configurations.
 */
@Configuration
@ComponentScan({"cabz"})
@PropertySource("classpath:environment.properties")
@EnableWebMvc
@EnableScheduling
public class ConfigurationService extends WebMvcConfigurerAdapter
{
    protected static Logger logger = LoggerFactory.getLogger(ConfigurationService.class);

    private @Autowired Environment env;
    private @Autowired MongoDbFactory mongo;
    private @Autowired PropertyReader propertyReader;

    public ConfigurationService() {
        System.err.println("ConfigurationService "+this);
        System.out.println("env : "+env);
    }
    
    public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "cabzdb");
	}

    @Bean
    public MongoTemplate mongoCabzDB() throws Exception {
        return new MongoTemplate(mongo);
    }
    
    @Bean
    public LoginModuleDataAccess loginModuleDataAccess() throws Exception{
    	return (LoginModuleDataAccess) new MongoAdminModuleDataAccessImpl();
    }
    
    @Bean
    public VendorModuleDataAccess vendorModuleDataAccess() throws Exception{
    	return (VendorModuleDataAccess) new MongoVendorModuleDataAccessImpl();
    }

}
