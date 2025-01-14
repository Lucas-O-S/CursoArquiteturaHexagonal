package consumer.apiconsumers.application.ports.out;

import java.util.Optional;

import consumer.apiconsumers.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String Id);
}
