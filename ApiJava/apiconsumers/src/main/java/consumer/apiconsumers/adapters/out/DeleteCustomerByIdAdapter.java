package consumer.apiconsumers.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;

import consumer.apiconsumers.adapters.out.repository.CustomerRepository;
import consumer.apiconsumers.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdAdapter implements  DeleteCustomerByIdOutputPort {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void Delete(String id){
        customerRepository.deleteById(id);
    }

}
