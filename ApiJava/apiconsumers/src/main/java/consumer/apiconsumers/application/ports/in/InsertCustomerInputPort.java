package consumer.apiconsumers.application.ports.in;

import consumer.apiconsumers.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void Insert(Customer customer, String zipCode );
}
