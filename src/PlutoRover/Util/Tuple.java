package PlutoRover.Util;

public class Tuple<X,Y> {

	X first;
	Y second;
	
	public Tuple(X first, Y second) {
		this.first = first;
		this.second = second;
	}
	
	public X getFst() {
		return first;
	}
	
	public Y getSnd() {
		return second;
	}
	
	
}
