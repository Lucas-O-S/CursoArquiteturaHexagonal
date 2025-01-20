package consumer.apiconsumers.application.core.useCase;

import consumer.apiconsumers.application.core.domain.Address;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.in.InsertCustomerInputPort;
import consumer.apiconsumers.application.ports.out.FindAddressByZipCodeOutputPort;
import consumer.apiconsumers.application.ports.out.InsertCustomerOutputPort;
import consumer.apiconsumers.application.ports.out.SendCpfForValidationOutputPort;



public class InsertCustomerUseCase implements InsertCustomerInputPort{
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        InsertCustomerOutputPort insertCustomerOutputPort,
        SendCpfForValidationOutputPort sendCpfForValidationOutputPort
            ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void Insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
    
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}
