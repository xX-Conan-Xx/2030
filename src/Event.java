import java.util.List;

public abstract class Event {
    final double time;
    final Customer customer;
    List<Server> servers;
    public Event(double time, Customer customer, List<Server> servers){
        this.time = time;
        this.customer = customer;
        this.servers = servers;
    }
    public abstract Event execute();
}
