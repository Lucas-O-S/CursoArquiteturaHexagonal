package consumer.apiconsumers.adapters.in.consumer.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private String isValidCpf;
    
}
