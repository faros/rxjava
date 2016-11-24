package rxjava._08.backpressure;

/*
 * slow subscriber, publisher is fast
 * 		
 */
public class MyRXJava {

	/*
	 * Observable is higher level of abstraction
	 */
	public static void main (String args[]) throws InterruptedException {
		// no problem losing some data
		DataGenerator.getFeed().onBackpressureDrop(); 
		
		// you care about all the data - buffer (doesn't make sense if your client is always slow)
		DataGenerator.getFeed().onBackpressureBuffer(); 
		
		// you care about all the data - make clients async (multiple subscribers, asynchronous)
		
		// you care about all the data - subscriber, you can request me for data (batchprocessing)
		DataGenerator.getFeed().rebatchRequests(30);
		
	}

}
