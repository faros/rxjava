package rxjava1._02controlling;

import java.util.UUID;

import rx.Observable;

public class MyObservable {


	public static Observable<String> getFeed() {
		/*
		 * TODO 11 : You can implement asynchronous i/o, computational operations, or even “infinite” streams of data 
		 * by designing your own Observable and implementing it with the create( ) method
		 * 
		 * Create and return an Observable using the create method. The Observable should, when subscribed return 10 String elements 
		 * (hint: use createString() provided). When the stream is done, send the complete signal.
		 */
		return null;
	}


	private static String createString() {
		return UUID.randomUUID().toString();
	}
}