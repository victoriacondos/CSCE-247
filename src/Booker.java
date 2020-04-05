import java.util.ArrayList;

/**
 * @author Elijah Dawkins
 * Purpose: Facilitates selling of tickets and transactions between inventory.
 */
public class Booker {
	private Event event;
	private Inventory inventory;
	/**
	 * Purpose: default constructor for booker.
	 * @param event: event connected to ticket.
	 * @param seat: seat connected to ticket.
	 */
	public Booker(Inventory inventory, Event event) {
		this.inventory = inventory;
		this.event = event;
		// TODO Auto-generated constructor stub ***-> needed for functionality?
	}
	
	/**
	 * Purpose: method for facilitating the purchase of tickets.
	 * @param event: event connected to ticket.
	 * @param seats: location / seating of ticket.
	 */
	public void BuyTickets(int numOfTickets, String time) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		int[] seats = new int[numOfTickets];
		int cost = 0;
		boolean oldSeat = true;
		Ticket ticket = null;
		int numOfSeats = this.event.seating.getSeats().length;
		System.out.println(this.event.seating.toString());
		for (int i = 0; i < numOfTickets; i++) {
			System.out.println("Enter Seat #" + (i+1));
			int seat = -1;
			oldSeat = true;
			while (oldSeat) {
				seat = Dialogue.getUserCommand(numOfSeats);
				oldSeat = false;
				if (this.event.seating.getSeats()[i] == true) oldSeat = true;
				for (int j = 0; j < seats.length; j++) {
					if (seat == seats[j]) oldSeat = true;
				}
				if (!oldSeat) {
					seats[i] = seat;
				}
			}
			this.event.seating.getSeats()[seat-1] = true;
			ticket = new Ticket(this.event, time, seat);
			tickets.add(ticket);
			cost += this.event.price;
		}
		System.out.println("Total Cost: " + cost + "\n You recieved " + (cost/10) + " Rewards Points");
		this.inventory.getPurchasedTickets().addAll(tickets);
	}
	
	/**
	 * Purpose: Method for facilitating the refund of tickets.
	 * @param tickets: tickets up for purchase
	 */
	public void RefundTickets(Ticket[] tickets) {
		// TODO
	}
	
	/**
	 * Purpose: Method for reward points.
	 * @param points: amount of points a user has.
	 */
	private void Reward(double points) {
		// TODO
	}
}
