package rxjava1._03async.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Observable;
import rx.schedulers.Schedulers;

/*
 * TOODO 20: reactive streams allow the subscribers to descide wether they want the result sync or async.
 * Let's try this now 
 */
public class Async {


	public static void main (String args[]) throws InterruptedException {
		Observable<String> feed = MyObservable.getFeed();

		 /*
		  * TOODO 21: In the previous exercise, the subscriber was running along in the main thread. 
		  * Let's find out ... 
		  * 
		  * Create 2 subscribers on our feed and observe that the first one needs to end before the second begins.
		  * (HINT, use the handle() method, provided below, that print's out the elements and the thread in which he's running)
		  */
		feed.subscribe(Async::handle);
		feed.subscribe(Async::handle);

		/*
		 * TOODO 22: Now let's make it async !
		 * Let's subscribe to the feed, but this time in a different thread
		 * 
		 * (HINT: Again, use the handle method below when you subscribe so you can see in which thread the subscriber is running)
		 * (HINT: use the singleThreadExecutor provided, which has a pool of 1 thread)
		 * (HINT: take a look at the subscribeOn method : http://reactivex.io/RxJava/javadoc/rx/Observable.html#subscribeOn(rx.Scheduler) )
		 */
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		feed.subscribeOn(Schedulers.from(newSingleThreadExecutor)).subscribe(Async::handle);

		/*
		 * TOODO 23: 
		 * Now, how to determine how many threads we need in the pool?
		 * 	for : 
		 * 		Computation intensive --> #threads = # cores
		 * 		IO intensive --> #threads > #cores : depending on blocking percentage
		 *  
		 * Subscribe to the feed, knowing that it's a computation intensive task ...
		 *  
		 * The RXJava Schedulers class makes this easier for us providing different convenience methods 
		 * 		computation() : Scheduler intended for computational work
		 * 		io() : Scheduler intended for IO-bound work
		 * 		newThread() : Scheduler that creates a new Thread for each unit of work
		 * 		from(java.util.concurrent.Executor executor) : Converts an Executor into a new Scheduler instance
		 */
		feed.subscribeOn(Schedulers.io()).subscribe(Async::handle);

		/*
		 * TOODO 24 we need some sleep so that the main thread doesn't end before our subscriber is finished
		 */
		Thread.sleep(10000);
	}

	public static void handle(String s) {
		System.out.println(s+" / thread "+ Thread.currentThread());
	}
}