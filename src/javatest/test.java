/**
 * 
 */

import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
/**
 * @author thucj_000
 *
 */

class ShowThread extends Thread
{
	static Lock lock;
	static int num = 0;
	int _step;
	String _content;
	Random rand;
	ShowThread(String content, int step)
	{
		System.out.println("Initialized content to "+ content);
		_content = content;
		_step = step;
		rand = new Random();
		if(lock == null)
		{
			lock = new ReentrantLock();
		}
	}
	public void run()
	{

		while(true)
		{
			lock.lock();
			num += _step;
			System.out.println("Thread "+ _content + ": num is " + num);
			lock.unlock();
			try {
				Thread.sleep(rand.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class test {

	/**
	 * @param args
	 */
	
	public static void show()
	{
		System.out.println("hihi");
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
			//System.out.println("Hi this is me!");
			Thread t1 = new ShowThread("b",1);
			Thread t2 = new ShowThread("a",-1);
			t1.start();
			t2.start();
			//t.join();
	}

}
