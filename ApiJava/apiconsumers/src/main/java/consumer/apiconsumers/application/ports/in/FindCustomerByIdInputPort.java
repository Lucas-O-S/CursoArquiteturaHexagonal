package consumer.apiconsumers.application.ports.in;

import consumer.apiconsumers.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);

}
