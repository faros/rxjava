package rxjava._02.controlling;

import rx.Observable;
import rxjava._02.controlling.solution.DataGenerator;

public class MyRXJava {

	public static void main (String args[]) {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed.subscribe(System.out::println);
	}
}
