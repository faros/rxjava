package rxjava._05.errorhandling;

import rx.Observable;

public class MyRXJava {

	public static void main (String args[]) {
		Observable<String> feed = DataGenerator.getFeed();
		System.out.println("got observable");
		
		feed.subscribe(System.out::println); // throws OnErrorNotImplementedException
		
//		feed.subscribe(System.out::println, MyRXJava::handleError); 
		
//		feed.onErrorResumeNext(throwable -> callBackup(throwable))
//			.subscribe(System.out::println, MyRXJava::handleError);
	}
	
	public static void handleError(Throwable e) {
		System.out.println("oh oh : "+e);
	}

	public static Observable<String> callBackup(Throwable e) {
		return Observable.create(subscriber -> subscriber.onNext("backup element"));
	}
}
