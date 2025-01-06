package consumer.apiconsumers.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import consumer.apiconsumers.adapters.out.repository.entity.CustomerEntity;

public interface CustomerRepository extends  MongoRepository<CustomerEntity, String> {

}
