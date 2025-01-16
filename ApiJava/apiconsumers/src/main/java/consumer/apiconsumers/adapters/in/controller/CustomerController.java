package consumer.apiconsumers.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consumer.apiconsumers.adapters.in.controller.Request.CustomerRequest;
import consumer.apiconsumers.adapters.in.controller.Response.CustomerResponse;
import consumer.apiconsumers.adapters.in.controller.mapper.CustomerMapper;
import consumer.apiconsumers.application.core.domain.Customer;
import consumer.apiconsumers.application.core.useCase.DeleteCustomerByIdUseCase;
import consumer.apiconsumers.application.ports.in.FindCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.in.InsertCustomerInputPort;
import consumer.apiconsumers.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;


    @PostMapping
    public  ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = customerMapper.toCustomer(request); 
        insertCustomerInputPort.Insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var  customerResponse = customerMapper.toCustomer(customer);
        
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> Update(
        @Valid @RequestBody CustomerRequest customerRequest,
         @PathVariable final String id 
         ) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.Update(customer, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(
        @PathVariable final String id
    ){
        deleteCustomerByIdUseCase.Delete(id);

        return ResponseEntity.noContent().build();

    }
    
    
}
