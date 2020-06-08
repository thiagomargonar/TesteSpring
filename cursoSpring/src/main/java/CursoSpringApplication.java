import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;

@SpringBootApplication(scanBasePackages = "br.com.school")
@ComponentScan({"br.com.school"})
@EntityScan("br.com.school")
@EnableJpaRepositories("br.com.school")
public class CursoSpringApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {

        SpringApplication.run(CursoSpringApplication.class, args);
    }

}
