package consumer.apiconsumers.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import consumer.apiconsumers.adapters.out.client.Response.AdressResponse;
import consumer.apiconsumers.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AdressResponse addressResponse);

}
