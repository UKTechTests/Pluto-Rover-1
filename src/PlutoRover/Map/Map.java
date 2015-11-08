package PlutoRover.Map;

public class Map {
	int[][] map;
	
	public Map(int height, int width) throws WrongMapValuesException {
		if(height > 0 && width > 0) {
			map = new int[height][width];
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

}
