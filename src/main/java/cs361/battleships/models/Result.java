package cs361.battleships.models;

public class Result {

	private AtackStatus attack;
	private Square location;

	public AtackStatus getResult() {
		return attack;
	}

	public void setResult(AtackStatus result) {
		this.attack = result;
	}

	public Ship getShip() {
		//TODO implement
		return null;
	}

	public void setShip(Ship ship) {
		//TODO implement
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square square) {
		this.location = square;
	}
}
