package consumer.apiconsumers.adapters.in.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import consumer.apiconsumers.adapters.in.consumer.Message.CustomerMessage;
import consumer.apiconsumers.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface  CustomerMessageMapper {
    @Mapping(target= "address", ignore=true)
    Customer toCustomer(CustomerMessage customerMessage);
}