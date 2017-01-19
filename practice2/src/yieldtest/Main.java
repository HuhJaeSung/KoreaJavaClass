package yieldtest;

public class Main {

	public static void main(String[] args) {
		
		// 두개의 Thread를 파생시키고, 실행을 요청한다.
		MyYieldThread my1 = new MyYieldThread();
		MyYieldThread my2 = new MyYieldThread();
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);

		t1.setPriority(9); // 기본이 5이다.
		t2.setPriority(1);
		t1.start();
		t2.start(); // t1이 먼저 runnable상태에 들어가고 t2가 다음에 들어간다. 하지만, 먼저 실행을 시키는 순서는 scheduler만 알 수 있다. 아마도, t1이 먼저 실행되긴 할것이다.
		
		System.out.println("Main이 종료되었습니다!");
	}

}
