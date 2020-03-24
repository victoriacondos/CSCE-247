/**
 * @author Elizabeth Stevenson
 * Purpose: holds the seating information
 */
public class Seating {
	private boolean seats[][];
	private boolean soldOut;
	
	/**
	 * Purpose: to get seat information
	 * @return the seats array
	 */
	public boolean[][] getSeats() {
		return seats;
	}
	
	/**
	 * Purpose: to set the seats array
	 * @param seats: if a seat is taken or not
	 */
	public void setSeats(boolean[][] seats) {
		this.seats = seats;
	}
	
	/**
	 * Purpose: to see if something is sold out
	 * @return the sold out boolean
	 */
	public boolean isSoldOut() {
		return soldOut;
	}
	
	/**
	 * Purpose: to set the soldOut boolean
	 * @param soldOut: if an event is soldout or not
	 */
	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}
	
	//TODO what does this method do?
	public int seatNumber(int row, int column) {
		return 1;
	}
	
	//TODO what are we saying here?
	public String toString() {
		return "something";
	}
}
