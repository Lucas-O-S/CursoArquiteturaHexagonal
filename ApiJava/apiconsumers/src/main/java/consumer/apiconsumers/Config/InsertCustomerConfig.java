package consumer.apiconsumers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import consumer.apiconsumers.adapters.out.FindAddressByZipCodeAdapter;
import consumer.apiconsumers.adapters.out.repository.InsertCustomerAdapter;
import consumer.apiconsumers.application.core.useCase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUserCase(
        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
        InsertCustomerAdapter insertCustomerAdapter

    ){

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
