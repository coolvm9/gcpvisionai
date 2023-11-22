package fusion.example.gcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties("spring.cloud.gcp.vision")
public class GcpvisionaiApplication {


    public static void main(String[] args) {
        SpringApplication.run(GcpvisionaiApplication.class, args);
//        System.out.println( gcpProjectIdProvider.getProjectId());
    }


}
