package rxjava1._04errorhandling;

import rx.Observable;

/*
 * TODO 30 : Let's treat errors with the attention that they diserve! 
 * Reactive streams have a dedicated error channel. Let's see how it works.
 * 
 * More info 
 * http://blog.danlew.net/2015/12/08/error-handling-in-rxjava/
 */
public class ErrorHandling {

	public static void main (String args[]) {
		Observable<String> feed = MyObservable.getFeed();
		System.out.println("got observable");
		
		/*
		 * TODO 32 Let's first see what happens when we just subscribe to the feed. 
		 * Run it ... what do you get? Why?
		 */

		/*
		 * TODO 33 OnErrorNotImplementedException.. mmm could it be that we forgot something? 
		 * Oh right, we should treat errors as first class citizens! 
		 * 
		 * Create an error handler, printing out the exception and feed it to the subscriber
		 */
		
		/*
		 * TODO 34 Did you notice that the data stopped flowing when the exception occured? 
		 * When an error occurs, the data channel get's closed automatically. Pretty clever don't you think? 
		 * 
		 * Now let's improve our error handling : 
		 *    When an error occurs, switch to a backup Observable that continuous to deliver data.
		 *    (HINT: what methods on our Observable could help us with that?)
		 */
	}

}
