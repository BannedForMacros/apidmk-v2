package DbPeru.Posm.Config;

import DbPeru.Posm.DB.DerbyConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(
   basePackages = {"DbPeru.Posm"}
)
@PropertySource({"classpath:application.properties"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {
   @Autowired
   private Environment environment;

   @Bean
   public ViewResolver getViewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }

   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler(new String[]{"swagger-ui.html"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/"});
      registry.addResourceHandler(new String[]{"/webjars/**"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"});
   }

   @Bean(
      name = {"MYSQL"}
   )
   public DriverManagerDataSource getDataSource() {
      DriverManagerDataSource bds = new DriverManagerDataSource();
      bds.setDriverClassName(this.environment.getRequiredProperty("spring.datasource.driver"));
      bds.setUrl(this.environment.getRequiredProperty("spring.datasource.url"));
      bds.setUsername(this.environment.getRequiredProperty("spring.datasource.username"));
      bds.setPassword(this.environment.getRequiredProperty("spring.datasource.password"));
      return bds;
   }

   @Bean(
      name = {"SQLSERVER"}
   )
   public DriverManagerDataSource getDataSource2() {
      DriverManagerDataSource bdss = new DriverManagerDataSource();
      bdss.setDriverClassName(this.environment.getRequiredProperty("spring.datasource.SQL.driver"));
      bdss.setUrl(this.environment.getRequiredProperty("spring.datasource.SQL.url"));
      bdss.setUsername(this.environment.getRequiredProperty("spring.datasource.SQL.username"));
      bdss.setPassword(this.environment.getRequiredProperty("spring.datasource.SQL.password"));
      return bdss;
   }

   @Bean(
      name = {"DERBY"}
   )
   public DriverManagerDataSource getDataSourceDerby() {
      String RutaBaseDatos = this.environment.getRequiredProperty("spring.datasource.DERBY.url");
      DerbyConnection ConnectionDerby = new DerbyConnection();
      ConnectionDerby.AccederBD(RutaBaseDatos);
      DriverManagerDataSource dm = new DriverManagerDataSource(RutaBaseDatos);
      dm.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
      return dm;
   }

   @Bean(
      name = {"transactiones"}
   )
   public PlatformTransactionManager transactionManager() {
      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
      transactionManager.setDataSource(this.getDataSourceDerby());
      return transactionManager;
   }
}
