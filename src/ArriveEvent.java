import java.util.List;

public class ArriveEvent extends Event{


    public ArriveEvent(Customer customer, List<Server> servers) {
        super(customer.getArrivalTime(), customer, servers);
    }

    @Override
    public String toString() {
        return this.time + customer.getCustomerID() + " arrives";
    }

    @Override
    public Event execute() {
        for(Server server:servers){
            if(server.isAvailable()==true){
                return new ServeEvent(customer,servers,server);
            }
        }

        for(Server server:servers){
            if(server.isHasWaitingCustomer()==false){
                return new WaitEvent(customer,servers,server);
            }
        }
        return new LeaveEvent(customer,servers);
    }
}
