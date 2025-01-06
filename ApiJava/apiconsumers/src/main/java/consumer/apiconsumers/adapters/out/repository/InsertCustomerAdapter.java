package consumer.apiconsumers.adapters.out.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import consumer.apiconsumers.adapters.out.repository.entity.CustomerEntity;
import consumer.apiconsumers.adapters.out.repository.mapping.CustomerEntityMapper;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
