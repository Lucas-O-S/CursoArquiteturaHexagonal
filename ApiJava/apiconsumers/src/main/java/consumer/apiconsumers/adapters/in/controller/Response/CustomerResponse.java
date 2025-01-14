package consumer.apiconsumers.adapters.in.controller.Response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;

    private AddressResponse address;

    private Boolean isValidCpf;
}
