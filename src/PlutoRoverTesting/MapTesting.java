package PlutoRoverTesting;

import static org.junit.Assert.*;
import PlutoRover.Map.*;

import org.junit.Test;

public class MapTesting {

	@Test(expected=WrongMapValuesException.class)
	public void creatingMapWithNegativeValuesReturnsException() throws WrongMapValuesException {
			Map map = new Map(-1,-1);
	}

	@Test(expected=WrongMapValuesException.class)
	public void creatingMapWithZeroValuesReturnsException() throws WrongMapValuesException {
			Map map = new Map(0,0);
	}
}
