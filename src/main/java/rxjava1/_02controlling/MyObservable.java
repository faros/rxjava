package rxjava1._02controlling;

import java.util.UUID;

import rx.Observable;

public class MyObservable {


	public static Observable<String> getFeed() {
		/*
		 * TODO 11 : In the previous exercise we used one of the Observables convenience methods (just, from) to create an observable. 
		 * If you want to have full control, you can also create your own observable using the create() method. 
		 * 
		 * Ex. for asynchronous i/o, computational operations, or even "infinite" streams of data 
		 * 
		 * Create and return an Observable using the Observable's create() method. 
		 * 
		 * The Observable should, when subscribed to, return 10 String elements 
		 * (hint: use createString() provided). When the stream is done, send the complete signal.
		 */
		return null;
	}


	private static String createString() {
		return UUID.randomUUID().toString();
	}
}