package rxjava1._06coldorhot;

import rx.Observable;

/*
 * TODO 50 : When does an Observable begin emitting its sequence of items? It depends on the Observable.
 * 		
 * 		A “hot” Observable may begin emitting items as soon as it is created, and so any observer who later subscribes to that Observable may 
 * 		start observing the sequence somewhere in the middle. 
 * 
 * 		A “cold” Observable, on the other hand, waits until an observer subscribes to it before it begins to emit items, 
 * 		and so such an observer is guaranteed to see the whole sequence from the beginning
 */
public class ColdOrHotObservable {

	/*
	 * TODO 51 : notice the MyObservable now returning numbers. Run this class and check the output
	 */
	public static void main (String args[]) throws InterruptedException {
		/*
		 * TODO 52 : Remember our async exercise? Because the subscribers are executed on the main thread, you only see the first subscriber. 
		 * Change this! Make sure the subscribers get executed async, and run the code. Now what happens?
		 * 
		 * TODO 53 : change the Observable into a 'hot' observable, run the code again, what happens?
		 */
		Observable<String> feed = MyObservable.getFeed();

		feed.subscribe(System.out::println); //subscriber 1
		Thread.sleep(2000);
		feed.subscribe(System.out::println); //subscriber 2

		Thread.sleep(30000);
	}
}
