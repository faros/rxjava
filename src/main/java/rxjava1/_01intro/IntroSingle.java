package rxjava1._01intro;

public class IntroSingle {

	/*
	 * TODO 6 Single
	 * 
	 * RxJava has developed an Observable variant called "Single"
	 * A Single is like an Observable, but instead of emitting a series of values it always either emits 1 value or an error notification
	 * 
	 * 		onSuccess 	: a Single passes this method the sole item that the Single emits
	 * 		onError 	: a Single passes this method the Throwable that caused the Single to be unable to emit an item
	 * 
	 * A Single will call only one of these methods, and will only call it once. Upon calling either method, the Single terminates and the subscription to it ends.
	 * 
	 * For this reason, instead of subscribing to a Single with the three methods you use to respond to notifications from an Observable 
	 * (onNext, onError, and onCompleted), you only use two methods to subscribe:
	 */
	public static void main (String args[] ) {
		// TODO 7 create a single, containing just (hint) 1 string element
		
		// TODO 8 subscribe to the single, printing the element
	}
}
