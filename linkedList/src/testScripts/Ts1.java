package testScripts;

import LoopedListGithub.*;

public class Ts1 {

	public static void main(String[] args) {
		LoopedList l = new LoopedList();
		for(int i = 0; i < 10; i++) {
			l.add(i);
		} 
		
		l.switchUp();
		
		//l.remove();
		
		System.out.println(l.toString());
		

	}

}
