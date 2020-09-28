import java.util.List;

public class ArriveEvent extends Event{


    public ArriveEvent(Customer customer, List<Server> servers) {
        super(customer.getArrivalTime(), customer, servers);
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) +" " + customer.getCustomerID() + " arrives";
    }

    @Override
    public Event execute() {
        for(Server server:servers){
            if(server.isAvailable()==true){
                return new ServeEvent(this.customer,this.servers,server);
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
