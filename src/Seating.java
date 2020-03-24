/**
 * @author Elizabeth Stevenson
 * Purpose: holds the seating information
 */
public class Seating {
	private boolean seats[];
	private int rowLength;
	private boolean soldOut;
	private int handicapSeats[];
	
	public Seating(int numOfSeats, int rowLength, int[] handicapped) {
		this.seats = new boolean[numOfSeats];
		this.rowLength = rowLength;
		this.handicapSeats = handicapped;
		soldOut = false;
	}

	/**
	 * Purpose: to get seat information
	 * @return the seats array
	 */
	public boolean[] getSeats() {
		return seats;
	}

	/**
	 * Purpose: to set the seats array
	 * @param seats: if a seat is sold or not
	 */
	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}
	
	/**
	 * Purpose: to see if seating is sold out
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
	
	public boolean isHandicap(int seat) {
		for (int i = 0; i < handicapSeats.length; i++) {
			if (seat+1 == handicapSeats[i]) return true;
		}
		return false;
	}
	
	/**
	 * Purpose: to convert seating data to a viewable format
	 * o = available
	 * X = sold
	 * G = handicap seat
	 * @return a seating chart
	 */
	public String toString() {
		String seating = "\t";
		if (soldOut) seating += "SOLD OUT";
		else {
			seating += "Seat in Row\t";
			for (int i = 1; i <= rowLength; i++) {
				int col = i%10;
				seating += col + " ";
			}
			int rows = (int) Math.ceil((double)seats.length/rowLength);
			for (int row = 0; row < rows; row++) {
				int firstSeat = row * rowLength + 1;
				int lastSeat = firstSeat + rowLength - 1;
				if (lastSeat > seats.length) lastSeat = seats.length;
				seating += "\n\tSeats " + firstSeat + "-" + lastSeat + "\t";
				for (int s = firstSeat-1; s < lastSeat; s++) {
					if (s < seats.length) {
						char marking = 'o';
						if (isHandicap(s)) marking = 'G';
						if (seats[s]) marking = 'X';
						seating += marking + " ";
					}
				}
			}
		}
		return seating;
	}
}
