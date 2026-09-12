package DbPeru.Posm.Config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan({"DbPeru.Posm"})
@Configuration
public class SpringRootConfig {
   @Autowired
   @Qualifier("DERBY")
   DataSource dataSource;

   @Bean(
      name = {"JDBCTEMPLATE"}
   )
   public JdbcTemplate getJdbcTemplate() {
      return new JdbcTemplate(this.dataSource);
   }
}
