package PlutoRover.Vehicle;

import PlutoRover.Map.Map;
import PlutoRover.Util.Cardinal;
import PlutoRover.Util.Directions;
import PlutoRover.Util.Tuple;

public abstract class Vehicle {
	int x;
	int y;
	Cardinal direction;
	Map map;
	
	public Vehicle(int x, int y, Cardinal direction, Map map) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.map = map;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Map getMap() {
		return map;
	}

	public Cardinal getDirection() {
		return direction;
	}

	public void setDirection(Cardinal direction) {
		this.direction = direction;
	}
	
	public abstract <X,Y> Tuple<X,Y> move(Directions direction);
	
	public abstract <X,Y> Tuple<X,Y> processCommands(String commands);
	
	
}
