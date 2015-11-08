package PlutoRover.Vehicle;

import PlutoRover.Map.Map;
import PlutoRover.Util.Cardinal;
import PlutoRover.Util.Directions;
import PlutoRover.Util.Tuple;

public class Rover extends Vehicle {

	public Rover(int x, int y, Cardinal direction, Map map) {
		super(x, y, direction, map);
	}

	@Override
	public Tuple<Integer, Integer> move(Directions direction) {
		Cardinal currentDirection = getDirection();
		int oldX = getX();
		int oldY = getY();
		
		switch(direction) {
			case FORWARD:
				switch(currentDirection) {
				case NORTH:
					x++;
					break;
				case SOUTH:
					x--;
					break;
				case EAST:
					y++;
					break;
				case WEST:
					y--;
					break;
				default:
					break;
				}
				break;
			case BACKWARDS:
				switch(currentDirection) {
				case NORTH:
					x--;
					break;
				case SOUTH:
					x++;
					break;
				case EAST:
					y--;
					break;
				case WEST:
					y++;
					break;
				default:
					break;
				}
				break;
			case LEFT:
				switch(currentDirection) {
				case NORTH:
					setDirection(Cardinal.WEST);
					break;
				case SOUTH:
					setDirection(Cardinal.EAST);
					break;
				case EAST:
					setDirection(Cardinal.NORTH);
					break;
				case WEST:
					setDirection(Cardinal.SOUTH);
					break;
				default:
					break;
				}
				break;
			case RIGHT:
				switch(currentDirection) {
				case NORTH:
					setDirection(Cardinal.EAST);
					break;
				case SOUTH:
					setDirection(Cardinal.WEST);
					break;
				case EAST:
					setDirection(Cardinal.SOUTH);
					break;
				case WEST:
					setDirection(Cardinal.NORTH);
					break;
				default:
					break;
				}
			default:
				break;
		}
		
		if(map.hasObstacle(getX(),getY())) {
			Tuple<Integer, Integer> obstacle = new Tuple<>(getX(), getY());
			x = oldX;
			y = oldY;
			return obstacle;
		}
		wrapAround();
		return null;
	}
	
	private void wrapAround() {
		if(x >= map.getHeight()) {
			x = 0;
		}
		
		if(y >= map.getWidth()) {
			y = 0;
		}
		
		if(x < 0) {
			x = map.getHeight() - 1;
		}
		
		if(y < 0) {
			y = map.getWidth() - 1;		
		}
	}

}
