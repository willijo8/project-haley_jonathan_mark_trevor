package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	private String shipType = "";

	public Ship(){
		occupiedSquares = new ArrayList<>();
	}

	public Ship(String kind) {
		shipType = kind;
		occupiedSquares = new ArrayList<>();
	}

	public List<Square> getOccupiedSquares() {
		return occupiedSquares;
	}
}
