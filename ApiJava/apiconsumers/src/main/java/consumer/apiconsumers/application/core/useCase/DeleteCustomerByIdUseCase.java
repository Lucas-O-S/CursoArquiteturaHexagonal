package consumer.apiconsumers.application.core.useCase;

import consumer.apiconsumers.application.ports.in.DeleteCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.in.FindCustomerByIdInputPort;
import consumer.apiconsumers.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements  DeleteCustomerByIdInputPort{
    

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ){
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }
    
    @Override
    public void Delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.Delete(id);
    }
}
