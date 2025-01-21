package consumer.apiconsumers.adapters.in.consumer.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import consumer.apiconsumers.adapters.in.consumer.mapper.CustomerMessageMapper;
import consumer.apiconsumers.application.ports.in.UpdateCustomerInputPort;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage ){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.Update(customer, customerMessage.getZipCode());

    }
}
