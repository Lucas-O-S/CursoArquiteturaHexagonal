package consumer.apiconsumers.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import consumer.apiconsumers.adapters.out.repository.CustomerRepository;
import consumer.apiconsumers.adapters.out.repository.mapping.CustomerEntityMapper;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.ports.out.UpdateCustomerOutputPort;

@Component
public class UpdateCustomerAdapter implements  UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CustomerEntityMapper customerEntityMapper; 

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
