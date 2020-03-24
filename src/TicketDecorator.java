/**
 * 
 * @author Victoria Condos
 * Purpose: Abstract base class that decorations inherit toString method from
 */
public abstract class TicketDecorator extends Ticket {
	public TicketDecorator(Event event, int seat) {
		super(event, seat);
		// TODO Auto-generated constructor stub
	}

	public abstract String toString();
}
