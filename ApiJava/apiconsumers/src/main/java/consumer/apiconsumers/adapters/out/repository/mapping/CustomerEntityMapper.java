package consumer.apiconsumers.adapters.out.repository.mapping;

import org.mapstruct.Mapper;

import consumer.apiconsumers.adapters.out.repository.entity.CustomerEntity;
import consumer.apiconsumers.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
