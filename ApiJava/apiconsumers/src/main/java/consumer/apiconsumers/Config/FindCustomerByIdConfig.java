package consumer.apiconsumers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import consumer.apiconsumers.adapters.out.FindCustomerByIdAdapter;
import consumer.apiconsumers.application.core.useCase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
        FindCustomerByIdAdapter findCustomerByIdAdapter
    ){

        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
