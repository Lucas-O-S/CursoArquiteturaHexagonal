package consumer.apiconsumers.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import consumer.apiconsumers.adapters.out.repository.CustomerRepository;
import consumer.apiconsumers.adapters.out.repository.mapping.CustomerEntityMapper;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String Id) {
        var customerEntity = customerRepository.findById(Id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}
