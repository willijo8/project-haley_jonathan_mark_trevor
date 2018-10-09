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
		// Is anything needed for default constructor?
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {


		// Need to generate occupied squares for this to work properly.
		List<Square> shipPlacement = ship.getOccupiedSquares();

		//Bounds validation on ship
		for (Square place: shipPlacement) {
			if (place.getRow() >= 10 || place.getColumn() >= 'j') {
				return false;
			}
		}

		//validation that ship does not conflict with other ships
		// ***Needs to be modified for all squares occupied by ship
		// ***Need double checking on this code, feels like there should be a better way to do this
		for (Ship allShips: this.ships) {
			List<Square> occupied = allShips.getOccupiedSquares();
			for (Square occu: occupied) {
				for (Square place: shipPlacement) {
					if (occu.getRow() == place.getRow() && occu.getColumn() == place.getColumn()) {
						return false;
					}
				}
			}
		}

		//store ship in list of ships
		this.ships.add(ship);

		//return true since all validation has been passed.
		return true;
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
		for (Result allResults: this.attacks) {
			if (allResults.getLocation().getColumn() == location.getColumn() && allResults.getLocation().getRow() == location.getRow()) {
				atackResult.setResult(AtackStatus.INVALID);
				return atackResult;
			}
		}

		//Validated that result is not INVALID
		atackResult.setLocation(location);

		//Check for ship at attack location
		// ***this currently only checks for hit and not sunk or surrender
		for (Ship ship: this.ships) {
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
		this.attacks.add(atackResult);
		return atackResult;
	}

	public List<Ship> getShips() {
		return this.ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public List<Result> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Result> attacks) {
		this.attacks = attacks;
	}
}