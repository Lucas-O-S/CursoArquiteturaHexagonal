package consumer.apiconsumers.application.ports.in;

import consumer.apiconsumers.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void Update(Customer customer, String zipCode);
}
