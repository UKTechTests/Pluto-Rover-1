package PlutoRover.Map;

public class Map {
	int[][] map;
	
	public Map(int height, int width) throws WrongMapValuesException {
		if(height > 0 && width > 0) {
			map = new int[height][width];
		}
		
		throw new WrongMapValuesException();
	}

}
