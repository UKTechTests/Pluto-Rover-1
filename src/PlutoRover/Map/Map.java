package PlutoRover.Map;

public class Map {
	boolean[][] map;
	
	public Map(int height, int width) throws WrongMapValuesException {
		if(height > 0 && width > 0) {
			map = new boolean[height][width];
		} else {
			throw new WrongMapValuesException();
		}
	}
	
	public int getHeight() {
		return map.length;
	}
	
	public int getWidth() {
		return map[0].length;
	}
	
	public boolean contains(int x, int y) {
		if(x >= 0 && x < getHeight() && y >=0 && y < getWidth()) {
			return true;
		}
		return false;
	}
	
	public void addObstacle(int x, int y) {
		if(contains(x,y)) {
			map[x][y] = true;
		}
	}
	
	public boolean hasObstacle(int x, int y) {
		if(contains(x,y)) {
			return map[x][y];
		}
		return false;
	}

}
