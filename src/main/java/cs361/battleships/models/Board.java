package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Ship> ships;
	private List<Result> attacks;

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		// TODO Implement
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		//Need to implement bound validation, waiting on Ship class

		//validation that ship does not conflict with other ships
		// ***Needs to be modified for all squares occupied by ship
		for (Ship allShips: ships) {
			List<Square> occupied = allShips.getOccupiedSquares();
			for (Square occu: occupied) {
				if (occu.getRow() == x && occu.getColumn() == y) {
					return false;
				}
			}
		}

		//store ship in list of ships
		ships.add(ship);

		return false;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {

		//set Variables
		Square location = new Square(x, y);
		Result atackResult = new Result();

		//check bounds
		if (x <= 1 || x >= 10 || y <= 'a' || y >= 'j') {
			atackResult.setResult(AtackStatus.INVALID);
			return atackResult;
		}

		//ensure attack location has not been made before
		for (Result allResults: attacks) {
			if (allResults.getLocation().getColumn() == location.getColumn() && allResults.getLocation().getRow() == location.getRow()) {
				atackResult.setResult(AtackStatus.INVALID);
				return atackResult;
			}
		}

		//Validated that result is not INVALID
		atackResult.setLocation(location);

		//Check for ship at attack location
		// ***this currently only checks for hit and not sunk or surrender
		for (Ship ship: ships) {
			List<Square> occupied = ship.getOccupiedSquares();
			for (Square occu: occupied) {
				if (occu.getRow() == x && occu.getColumn() == y) {
					atackResult.setResult(AtackStatus.HIT);
					//Check if ship is sunk, if yes check if all ships are sunk
				} else {
					atackResult.setResult(AtackStatus.MISS);
				}
			}
		}
		attacks.add(atackResult);
		return atackResult;
	}

	public List<Ship> getShips() {
		//TODO implement
		return null;
	}

	public void setShips(List<Ship> ships) {
		//TODO implement
	}

	public List<Result> getAttacks() {
		//TODO implement
		return null;
	}

	public void setAttacks(List<Result> attacks) {
		//TODO implement
	}
}