package rxjava._02.unsubscribing.solution;

import rx.Observable;
import rx.Subscriber;

public class MyRXJava {

	public static void main (String args[]) {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		//feed.subscribe(System.out::println, System.out::println);

		feed.subscribe(new Subscriber<String>() {
			public void onCompleted() {
				System.out.println("DONE");
			};
			public void onError(Throwable t) {
				System.out.println("OEPS : "+ t);
			};
			public void onNext(String arg) {
				System.out.println(arg);
				double random = Math.random();
				if (random > 0.85) {
					System.out.println("unsubscribing");
					unsubscribe();
				}
			};
		});
	}

	public static void handle(String s) {
		System.out.println(s+" / thread "+ Thread.currentThread());
	}
}
