package consumer.apiconsumers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import consumer.apiconsumers.application.core.useCase.UpdatecustomerUserCase;
import consumer.apiconsumers.application.ports.in.FindCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.out.FindAddressByZipCodeOutputPort;
import consumer.apiconsumers.application.ports.out.UpdateCustomerOutputPort;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdatecustomerUserCase updatecustomerUserCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        FindAddressByZipCodeOutputPort findAddressByZipCodePort,
        UpdateCustomerOutputPort updateCustomerOutputPort

    ){

        return new UpdatecustomerUserCase(findCustomerByIdInputPort, findAddressByZipCodePort, updateCustomerOutputPort);
    }
}
