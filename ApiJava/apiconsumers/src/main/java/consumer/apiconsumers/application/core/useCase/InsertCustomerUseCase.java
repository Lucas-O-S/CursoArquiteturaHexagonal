package consumer.apiconsumers.application.core.useCase;

import consumer.apiconsumers.application.core.domain.Address;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.out.FindAddressByZipCodeOutputPort;
import consumer.apiconsumers.application.ports.out.InsertCustomerOutputPort;



public class InsertCustomerUseCase {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void Insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
    
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}
