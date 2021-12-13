package bgu.spl.mics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

class FutureTest {
	
	private static Future<String> f;
	public static String s;
	
	
	@Test
	public void testIsDone() {
		f=new Future<String>();
		assertFalse(f.isDone());
		f.resolve("5");
		assertTrue(f.isDone());
		f=new Future<String>();
	}
	
	@Test
	public void testBlockingGet() {
		f=new Future<>();
		Thread t=new Thread(()->s=f.get());
		t.run();
		assertNull(s);
		f.resolve("hi");
		assertEquals("hi", s);
	}
	
	@Test
	public void testResolve() {
		f=new Future<>();
		assertFalse(f.isDone());
		s="";
		f.resolve(s);
		assertEquals(s, f.get());
		assertTrue(f.isDone());
	}
	
	@Test
	public void testGet() {
		f=new Future<>();
		TimeUnit unit=TimeUnit.SECONDS;
		Thread t=new Thread(()->s=f.get(3, unit));
		t.run();
		assertNull(s);
		try {
			t.join();
		}catch(InterruptedException e) {}
		assertNull(s);
		t.run();
		f.resolve("");
		try {
			wait(unit.toMillis(1));
		}catch(InterruptedException e) {}
		assertEquals("",s);
		
	}
	

}
