package threadsynchronization;

import java.util.ArrayList;

public class SharedObject {

	// 이 instance를 3개의 Thread가 공유한다.
	ArrayList<String> list = new ArrayList<String>();
	
	public SharedObject() {
		// instance가 만들어지고 
		list.add("1번 홍길동");
		list.add("2번 이순신");
		list.add("3번 강감찬");
	}
	public void printlist(){
		for(String t : list){
			System.out.println(t);
		}
	}
}
