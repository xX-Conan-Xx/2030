import java.util.List;

public class ServeEvent extends Event{
    private final Server server;
    public ServeEvent( Customer customer, List<Server> servers, Server server) {
        super(customer.getArrivalTime(), customer, servers);
        this.server = server;
        this.servers.set(servers.indexOf(server),new Server(server.getIdentifier(),false,false, this.time+1));
    }

    @Override
    public String toString() {
        return this.time + customer.getCustomerID() + " served by " + server.getIdentifier();
    }

    @Override
    public Event execute() {
        return new DoneEvent(this.customer,this.servers,this.server);
    }
}
