package consumer.apiconsumers.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import consumer.apiconsumers.adapters.in.controller.Request.CustomerRequest;
import consumer.apiconsumers.adapters.in.controller.Response.CustomerResponse;
import consumer.apiconsumers.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustomer(Customer customer);
}
