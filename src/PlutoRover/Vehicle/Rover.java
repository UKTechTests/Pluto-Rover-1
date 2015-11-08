package PlutoRover.Vehicle;

import PlutoRover.Util.Cardinal;
import PlutoRover.Util.Directions;
import PlutoRover.Util.Tuple;

public class Rover extends Vehicle {

	public Rover(int x, int y, Cardinal direction) {
		super(x, y, direction);
	}

	@Override
	public <X, Y> Tuple<X, Y> move(Directions direction) {
		Cardinal currentDirection = getDirection();
		
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
		return null;
	}

	@Override
	public <X, Y> Tuple<X, Y> processCommands(String commands) {
		return null;
	}

}
