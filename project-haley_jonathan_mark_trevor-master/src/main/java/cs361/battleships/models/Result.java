package cs361.battleships.models;

public class Result {

	private AtackStatus attack;
	private Square location;

//Initializing Result with the necessary components to set the variables
	public Result (AtackStatus attack, int x, char y) {
		this.attack = attack;
//Turns the int and char variables into a square
		this.location = new Square (int x, char y);
	}

//Returns the attack status
	public AtackStatus getResult() {
		return attack;
	}

//Sets the attack status
	public void setResult(AtackStatus result) {
		this.attack = result;
	}

//Not sure if needed since ship setting is handled in a different class
//	public Ship getShip() {
		//TODO implement
//		return null;
//	}

//	public void setShip(Ship ship) {
		//TODO implement
//	}

//Returns the square object which contains the int and char location
	public Square getLocation() {
		return location;
	}

//I don't think we need this if we have the initialization up top
//Resets location of result to predetermined square
	public void setLocation(Square square) {
		this.location = square;
	}
}
