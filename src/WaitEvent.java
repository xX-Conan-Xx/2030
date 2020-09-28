import java.util.List;

public class WaitEvent extends Event{
    private final Server newServer;
    public WaitEvent(Customer customer, List<Server> servers,Server server) {
        super(customer.getArrivalTime(), customer, servers);
        this.newServer = new Server(server.getIdentifier(),true,true, server.getNextAvailableTime());
        this.servers.set(servers.indexOf(server),newServer);
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) + " " + customer.getCustomerID() + " waits to be served by " + newServer.getIdentifier();
    }

    @Override
    public Event execute() {
        return new ServeEvent(customer,servers,newServer);
    }
}
