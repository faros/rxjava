package rxjava1._02controlling;

/*
 * TODO 10 : In this exercise we'll learn to control the data stream. 
 * 
 */
public class Controlling {

	
	public static void main(String args[]) {
		/*
		 * TODO 12: get The observable and subscribe to it, you should see the 10 elements coming through (hint: print them out)
		 * Make sure that when when the complete signal is send, you print out "DONE"
		 */


		/*
		 * TODO 13: maybe after a while we're no longer interested in receiving data from our Observable. 
		 * 
		 * Subscribe to the feed (change the Observable to return an endless stream of String elements instead of just 10) and 
		 * randomly unsubscribe from it (hint: Math.random() > 0.85)
		 *  
		 * Make sure the stream doesn't continue to return elements!
		 */
	}
}
