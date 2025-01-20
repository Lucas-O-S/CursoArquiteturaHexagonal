package consumer.apiconsumers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import consumer.apiconsumers.adapters.out.FindAddressByZipCodeAdapter;
import consumer.apiconsumers.adapters.out.repository.InsertCustomerAdapter;
import consumer.apiconsumers.application.core.useCase.InsertCustomerUseCase;
import consumer.apiconsumers.application.ports.out.SendCpfForValidationOutputPort;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUserCase(
        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
        InsertCustomerAdapter insertCustomerAdapter,
        SendCpfForValidationOutputPort sendCpfForValidationOutputPort

    ){

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter,sendCpfForValidationOutputPort);
    }
}
