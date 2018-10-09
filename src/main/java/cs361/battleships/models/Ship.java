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

	public String getShipType(){
		return shipType;
	}

	public List<Square> getOccupiedSquares() {
		return occupiedSquares;
	}

	public void setOccupiedSquares(int x, char y, boolean isVertical){
		switch(getShipType()){
			case "MINESWEEPER":
				if(isVertical){
					for (int z = 0; z < 2; z++){
						Square sq = new Square(x,y);
						occupiedSquares.add(sq);
						x++;
					}
				} else {
					for (int z = 0; z < 2; z++){
						Square sq = new Square(x,y);
						occupiedSquares.add(sq);
						y++;
					}
				}
				break;
			case "DESTROYER":
				if(isVertical){
					for (int z = 0; z < 3; z++){
						Square sq = new Square(x,y);
						occupiedSquares.add(sq);
						x++;
					}
				} else {
					for (int z = 0; z < 3; z++){
						Square sq = new Square(x,y);
						occupiedSquares.add(sq);
						y++;
					}
				}
				break;
			case "BATTLESHIP":
				if(isVertical){
					for (int z = 0; z < 4; z++){
						Square sq = new Square(x,y);
						occupiedSquares.add(sq);
						x++;
					}
				} else {
					for (int z = 0; z < 4; z++){
						Square sq = new Square(x,y);
						occupiedSquares.add(sq);
						y++;
					}
				}
				break;
			default:
				break;
		}
	}
}
