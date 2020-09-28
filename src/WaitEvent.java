import java.util.List;

public class WaitEvent extends Event{
    private final Server server;
    public WaitEvent(Customer customer, List<Server> servers,Server server) {
        super(customer.getArrivalTime(), customer, servers);
        this.server = server;
        this.servers.set(servers.indexOf(server),new Server(server.getIdentifier(),true,true, server.getNextAvailableTime()));
    }

    @Override
    public String toString() {
        return this.time + customer.getCustomerID() + " waits to be served by " + server.getIdentifier();
    }

    @Override
    public Event execute() {
        return null;
    }
}
