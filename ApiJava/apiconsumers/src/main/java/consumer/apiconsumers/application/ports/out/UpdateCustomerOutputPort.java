package consumer.apiconsumers.application.ports.out;

import consumer.apiconsumers.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
