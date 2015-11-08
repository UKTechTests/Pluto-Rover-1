package PlutoRover.Util;

public class Tuple<X,Y> {

	X first;
	Y second;
	
	public Tuple(X first, Y second) {
		this.first = first;
		this.second = second;
	}
	
	private X getFst() {
		return first;
	}
	
	private Y getSnd() {
		return second;
	}
}
