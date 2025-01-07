package consumer.apiconsumers.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consumer.apiconsumers.adapters.in.controller.Request.CustomerRequest;
import consumer.apiconsumers.adapters.in.controller.mapper.CustomerMapper;
import consumer.apiconsumers.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public  ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = customerMapper.toCustomer(request); 
        insertCustomerInputPort.Insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }
    
}
