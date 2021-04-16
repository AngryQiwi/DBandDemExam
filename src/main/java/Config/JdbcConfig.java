package Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {

    public static String username;
    public static String password;
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public DriverManagerDataSource dataSource(){
        return new DriverManagerDataSource("jdbc:postgresql://127.0.0.1:5432/ExamDB", "postgres", "ianeho4u");
    }
}
