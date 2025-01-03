package consumer.apiconsumers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFeignClients
@SpringBootApplication
public class ApiconsumersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiconsumersApplication.class, args);
	}

}
