package consumer.apiconsumers.application.core.useCase;

import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.in.FindCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
    
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    
    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
            return findCustomerByIdOutputPort.find(id).orElseThrow(()-> new RuntimeException("Customer not found"));
        
    }





}
