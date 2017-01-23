package rxjava1._01intro.solution;

import rx.Completable;
import rx.Completable.OnSubscribe;
import rx.CompletableSubscriber;
import rx.functions.Action0;

/*
 * TOODO 9 Completable
 * 
 * Represents a deferred computation without any value but only indication for completion or exception
 * 
 * More info : http://akarnokd.blogspot.be/2015/12/the-new-completable-api-part-2-final.html
 */
public class IntroCompletable {
	
	public static void main(String args[]) throws InterruptedException {
		Completable c = Completable.create(new OnSubscribe() {

			@Override
			public void call(CompletableSubscriber a) {
				System.out.println("completable thread : "+Thread.currentThread());
				try {
					Thread.sleep(1000); //compute intensive task
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				a.onCompleted();
			}
		});

		c.subscribe(new Action0() {
			@Override
			public void call() {
				System.out.println("completable DONE");
			}
		});
	}
}
