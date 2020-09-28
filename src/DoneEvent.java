import java.util.List;

public class DoneEvent extends Event{
    private final Server server;
    public DoneEvent(Customer customer, List<Server> servers ,Server server) {
        super(customer.getArrivalTime()+1, customer, servers);
        this.server = server;
        this.servers.set(servers.indexOf(server),new Server(server.getIdentifier(),true,server.isHasWaitingCustomer(), server.getNextAvailableTime()));
    }

    @Override
    public String toString() {
        return this.time + customer.getCustomerID() + " done serving by " + server.getIdentifier();
    }

    @Override
    public Event execute() {
        return null;
    }
}
