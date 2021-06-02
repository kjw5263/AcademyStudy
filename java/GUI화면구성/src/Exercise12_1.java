

class Exercise12_1 {
	
	
	
	public static void main(String args[]) {
		Thread1 thread1 = new Thread1();
		
		thread1.start();
	}
}

class Thread1 extends Thread {


	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print('-');
		}
	}
	
}