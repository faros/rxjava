package rxjava1._03async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Observable;
import rx.schedulers.Schedulers;

/*
 * TODO 20: reactive streams allow the subscribers to descide wether they want the result sync or async.
 * Let's try this now 
 */
public class Async {


	public static void main (String args[]) throws InterruptedException {
		/*
		 * http://www.grahamlea.com/2014/07/rxjava-threading-examples/
		 * Some people assume that, because RxJava is all about "asynchronous sequences", everything will happen on different threads by default, 
		 * but that's not the case
		 */
		
		/*
		 * Observable and subscriber run on the same (main) thread
		 */
		Observable<Integer> o = Observable.from(new Integer[]{1, 2, 3, 4, 5});
		o.subscribe(v -> System.out.println(v+" , on thread : "+Thread.currentThread())); 


		/*
		 * subscribeOn(Scheduler) function
		 * 
		 * This function produces a new Observable which will cause your subscription to occur on a thread retrieved from the specified scheduler 
		 * instead of the thread from which subscribe() is called
		 * 
		 * Using the subscribeOn method on the Observable, the subscriber now runs on different thread
		 * Don't forget to add Thread.sleep, or the main thread will have exited.
		 * 
		 */
		Observable<Integer> oAsync = Observable.from(new Integer[]{1, 2, 3, 4, 5});
		oAsync.subscribeOn(Schedulers.io()).subscribe(v -> System.out.println(v+" , on thread : "+Thread.currentThread())); 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Observable<String> feed = MyObservable.getFeed();

		 /*
		  * TODO 21: In the previous exercise, the subscriber was running along in the main thread. 
		  * Let's find out ... 
		  * 
		  * Create 2 subscribers on our feed and observe that the first one needs to end before the second begins.
		  * (HINT, use the handle() method, provided below, that print's out the elements and the thread in which he's running)
		  */

		/*
		 * TODO 22: Now let's make it async !
		 * Let's subscribe to the feed, but this time in a different thread
		 * 
		 * (HINT: Again, use the handle method below when you subscribe so you can see in which thread the subscriber is running)
		 * (HINT: use the singleThreadExecutor provided, which has a pool of 1 thread)
		 * (HINT: take a look at the subscribeOn method : http://reactivex.io/RxJava/javadoc/rx/Observable.html#subscribeOn(rx.Scheduler) )
		 */
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

		/*
		 * TODO 23: 
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

		/*
		 * TODO 24 we need some sleep so that the main thread doesn't end before our subscriber is finished
		 */
		Thread.sleep(10000);
	}

	public static void handle(String s) {
		System.out.println(s+" ("+ Thread.currentThread());
	}
}