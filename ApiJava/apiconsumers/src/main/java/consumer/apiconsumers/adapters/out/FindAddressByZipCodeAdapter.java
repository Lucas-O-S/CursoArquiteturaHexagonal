package consumer.apiconsumers.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import consumer.apiconsumers.adapters.out.client.FindAddressByZipCodeClient;
import consumer.apiconsumers.adapters.out.client.mapper.AddressResponseMapper;
import consumer.apiconsumers.application.core.domain.Address;
import consumer.apiconsumers.application.ports.out.FindAddressByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements  FindAddressByZipCodeOutputPort{

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.findAddressByZipCode(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
