package consumer.apiconsumers.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import consumer.apiconsumers.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort{
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void Send(String cpf){
        kafkaTemplate.send("tp-cpf-validation",cpf);
    }
    
}
