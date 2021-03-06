import java.util.List;

public class ServeEvent extends Event{
    private final Server newServer;
    public ServeEvent( Customer customer, List<Server> servers, Server server) {
        super(Math.max(server.getNextAvailableTime(),customer.getArrivalTime()), customer, servers);
        this.newServer = new Server(server.getIdentifier(),false,false, this.time+1);
        this.servers.set(servers.indexOf(server),newServer);
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) + " " + customer.getCustomerID() + " served by " + newServer.getIdentifier();
    }

    @Override
    public Event execute() {
        return new DoneEvent(this.customer,this.servers,this.newServer);
    }
}
