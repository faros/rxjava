package rxjava1._07backpressure.solution;

import rx.Observable;
import rx.schedulers.Schedulers;

/*
 * TOODO 60 Suppose the consumer cannot keep up with the producer, what can you do?
 * We need mechanisms to control the producer so that the consumer does not get overwhelmed. 
 * These mechanisms can come in either the form of lossy or loss-less operations. 
 * For example, if you miss a few mouse movements, it may not be a problem, however, if you miss a few bank transactions, that could definitely be a problem.
 *  
 *  Extra info :
 *  http://stackoverflow.com/documentation/rx-java/2341/backpressure#t=201701211625202653688
 *  https://github.com/ReactiveX/RxJava/wiki/Backpressure
 *  http://stackoverflow.com/documentation/rx-java/2341/backpressure#t=201701211625202653688 
 */
public class BackPressureHandling {
	
	public static void main (String args[]) throws InterruptedException {
		
		/*
		 * TOODO 62 Did you get an exception? A MissingBackpressureException? Great! Do you know why? 
		 * 
		 * (spoiler alert ! ;-))
		 * We just created an extreme case of a fast and a slow producer : 
		 * 		o1 being the fast one in this case, causing the buffer of the zip function to overload
		 * 		o2 being the slow one, meaning he doesn't produce any results 
		 * 
		 * Why? Because o1 & o2 all run in the main thread meaning o2 cannot produce any numbers until o1 is finished,
		 * but o1 is an endless stream... so our zip function only gets items from 1 observable, stores that in a
		 * buffer waiting for o2 until the buffer of the zip element hits the limit and throws a MissingBackpressureException. 
		 * 
		 * We saw an interesting feature in 03async that can help us, so let's make sure f1 & f2 run in separate threads (simultaniuously) 
		 * allowing the zip function to combine them and run the application! 
		 * 
		 * Should be ok now, right? Let's continue and break it again! 
		 */
//		Observable<String> o1 = MyObservable.getFeed1();
//		Observable<String> o1 = MyObservable.getFeed1().subscribeOn(Schedulers.io());
		Observable<String> o1 = MyObservable.getFeed1().subscribeOn(Schedulers.io()).onBackpressureDrop();
		Observable<String> o2 = MyObservable.getFeed2();

		/*
		 * TOODO 64 Our MissingBackpressureException is back in town ... how inconvenient!
		 * We created our own Observable which doesn't handle backpressure, so we'll have to set a strategy to cope with the overload
		 * Change the fast observable to use a drop strategy when the zip operator downstream gets flooded with items
		 * 
		 * Take a look at the output, you should notice that after a while the zip operator drops some messages to cope with the load. 
		 */
		
		/*
		 * TOODO 61 Let's take a look at the zipWith operator : 
		 * http://reactivex.io/RxJava/javadoc/rx/Observable.html#zipWith(rx.Observable,%20rx.functions.Func2) 
		 * 
		 * The zipWith operator returns an Observable that emits items that are the result of applying a specified function to pairs of values, 
		 * one each from the source Observable and another specified Observable
		 * 
		 * So to get started, let's use observable o1 & observable o2 as input for a zip function that combines elements from both in 1 new Observable 
		 * and print the result by subscribing to it
		 * 
		 * (HINT : the zip function = (s1, s2) -> s1 + " / "+s2 )
		 * 
		 * What happens when you run the code? Go on to find out ...
		 */ 
		o1.zipWith(o2, ((s1, s2) -> s1 + " / "+s2)).subscribe(System.out::println);
		

		Thread.sleep(10000);
	}
}