package consumer.apiconsumers.application.core.useCase;

import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.in.FindCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.in.UpdateCustomerInputPort;
import consumer.apiconsumers.application.ports.out.FindAddressByZipCodeOutputPort;
import consumer.apiconsumers.application.ports.out.UpdateCustomerOutputPort;

public class UpdatecustomerUserCase implements  UpdateCustomerInputPort {
    
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodePort;
    private final UpdateCustomerOutputPort UpdateCustomerOutputPort;

    public UpdatecustomerUserCase( 
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        FindAddressByZipCodeOutputPort findAddressByZipCodePort,
        UpdateCustomerOutputPort updateCustomerOutputPort
        ){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodePort = findAddressByZipCodePort;
        this.UpdateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void Update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        
    }
}
