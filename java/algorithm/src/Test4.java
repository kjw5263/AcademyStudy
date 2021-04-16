abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	abstract void stop();

}

class Marin {
	int x, y;
	void move(int x, int y) { }
	void stop() { } 
	void stimPack() {}
}

class Tank{
	int x, y;
	void move(int x, int y) { }
	void stop() { } 
	void changeMode() { }
}

class Dropship {
	int x, y;
	void move(int x, int y) { }
	void stop() { } 
	void load() { }
	void unload() { }
}

public class Test4 {

	public static void main(String[] args) {

	}

}
