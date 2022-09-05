
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public SistemaProperties sistemaProperties() {
        return new SistemaProperties();
    }

    @Bean(name = "aplication")
    public JdbcTemplate jdbcTemplate(SistemaProperties sistemaProperties) throws NamingException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup(sistemaProperties.getParametroString("jndi.app"));

        return new JdbcTemplate(dataSource);
    }

    @Bean
    public Log4jListener executeLog4jListener() {
        return new Log4jListener();
    }

}