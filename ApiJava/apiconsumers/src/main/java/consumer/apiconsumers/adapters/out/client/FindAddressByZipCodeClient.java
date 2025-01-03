package consumer.apiconsumers.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import consumer.apiconsumers.adapters.out.client.Response.AdressResponse;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface FindAddressByZipCodeClient {
    
    @GetMapping("{zipCode}/json")
    AdressResponse findAddressByZipCode(@PathVariable("zipCode") String zipCode);
}
