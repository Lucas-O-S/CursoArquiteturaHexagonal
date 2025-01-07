package consumer.apiconsumers.application.core.useCase;

import consumer.apiconsumers.application.core.domain.Address;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.in.InsertCustomerInputPort;
import consumer.apiconsumers.application.ports.out.FindAddressByZipCodeOutputPort;
import consumer.apiconsumers.application.ports.out.InsertCustomerOutputPort;



public class InsertCustomerUseCase implements InsertCustomerInputPort{
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void Insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
    
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}
