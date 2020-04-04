/**
 * 
 * @author Victoria Condos
 * Purpose: A ticket is printed to a .txt file
 */
import java.io.*;//TODO- not sure what im using yet so including all

public class PrintTicketCommand {
	private Ticket ticket;
	/**
	 * Purpose: sets private ticket to param ticket to be used in printing
	 * @param ticket: Ticket that needs to be printed
	 */
	public PrintTicketCommand (Ticket ticket) {
		this.ticket = ticket;
	}
	/**
	 * Purpose: creates .txt file of ticket info
	 */
	public void TicketWriter() throws IOException {
		String ticketContent = this.ticket.toString();
		
		FileOutputStream outputStream = new FileOutputStream ("ticket.txt");
		byte[] strToBytes = ticketContent.getBytes();
		outputStream.write(strToBytes);
		outputStream.close();
	}
}
