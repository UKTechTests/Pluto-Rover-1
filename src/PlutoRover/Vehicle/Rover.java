package PlutoRover.Vehicle;

import PlutoRover.Map.Map;
import PlutoRover.Util.Cardinal;
import PlutoRover.Util.Directions;
import PlutoRover.Util.Tuple;

public class Rover extends Vehicle {

	public Rover(int x, int y, Cardinal direction, Map map) {
		super(x, y, direction, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tuple<Integer, Integer> move(Directions direction) {
		Cardinal currentDirection = getDirection();

		switch(direction) {
			case FORWARD:
				switch(currentDirection) {
				case NORTH:
					if(map.hasObstacle(getX()+1,getY())) {
						 return new Tuple<>(getX()+1, getY());
					}
					x++;
					break;
				case SOUTH:
					if(map.hasObstacle(getX()-1,getY())) {
						 return new Tuple<>(getX()-1, getY());
					}
					x--;
					break;
				case EAST:
					if(map.hasObstacle(getX(),getY()+1)) {
						 return new Tuple<>(getX(), getY()+1);
					}
					y++;
					break;
				case WEST:
					if(map.hasObstacle(getX(),getY()-1)) {
						 return new Tuple<>(getX(), getY()-1);
					}
					y--;
					break;
				default:
					break;
				}
				break;
			case BACKWARDS:
				switch(currentDirection) {
				case NORTH:
					if(map.hasObstacle(getX()-1,getY())) {
						 return new Tuple<>(getX()-1, getY());
					}
					x--;
					break;
				case SOUTH:
					if(map.hasObstacle(getX()+1,getY())) {
						 return new Tuple<>(getX()+1, getY());
					}
					x++;
					break;
				case EAST:
					if(map.hasObstacle(getX(),getY()-1)) {
						 return new Tuple<>(getX(), getY()-1);
					}
					y--;
					break;
				case WEST:
					if(map.hasObstacle(getX(),getY()+1)) {
						 return new Tuple<>(getX(), getY()+1);
					}
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
