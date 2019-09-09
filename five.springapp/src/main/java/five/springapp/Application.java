package five.springapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@Slf4j
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }
//    public static void main(String[] args) {
//
//        log.info(ServiceLoader.load(FiveService.class).findFirst().get().five("umba").toString());
//    }
}
