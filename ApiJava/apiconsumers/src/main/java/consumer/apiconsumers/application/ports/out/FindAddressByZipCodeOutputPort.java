package consumer.apiconsumers.application.ports.out; 
import consumer.apiconsumers.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCioe);
}
