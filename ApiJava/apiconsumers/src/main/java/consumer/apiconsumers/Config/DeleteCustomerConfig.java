package consumer.apiconsumers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import consumer.apiconsumers.application.core.useCase.DeleteCustomerByIdUseCase;
import consumer.apiconsumers.application.ports.in.FindCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.out.DeleteCustomerByIdOutputPort;


@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
          FindCustomerByIdInputPort findCustomerByIdInputPort,
        DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort

    ){

        return new DeleteCustomerByIdUseCase(findCustomerByIdInputPort, deleteCustomerByIdOutputPort);
    }
}
