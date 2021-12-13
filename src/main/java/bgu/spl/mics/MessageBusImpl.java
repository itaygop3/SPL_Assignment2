package bgu.spl.mics;

import java.util.Queue;
import java.util.Vector;
/**
 * The {@link MessageBusImpl class is the implementation of the MessageBus interface.
 * Write your implementation here!
 * Only private fields and methods can be added to this class.
 */
public class MessageBusImpl implements MessageBus {
	
	private static MessageBusImpl msgBus = new MessageBusImpl();
	
	private Vector<Queue<Message>> mcroSrvcQs;
	private int size;
	private Vector<Vector<MicroService>> eventSubscribersLists; //there will be another field (map) that will tell which cell is which type pf event
	private Vector<Vector<MicroService>> brodcastSubscribersLists;//same   might join them to one eventually
	
	public int size() {
		return size;
	}
	
	public <T> boolean isSubscribedToEvent(Class<? extends Event<T>> type, MicroService m) {
		//TODO not the real implementation
		return true;
	}
	public boolean isSubscribedToBroadcast(Class<? extends Broadcast> type, MicroService m) {
		//TODO not the real implementation
		return true;
	}
	
	public boolean isInMsgBus(MicroService m) {
		//TODO not the real implementation
		return true;
	}
	
	private MessageBusImpl() {
		mcroSrvcQs=new Vector<Queue<Message>>();
		size=0;
	}

	@Override
	public <T> void subscribeEvent(Class<? extends Event<T>> type, MicroService m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeBroadcast(Class<? extends Broadcast> type, MicroService m) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void complete(Event<T> e, T result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendBroadcast(Broadcast b) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public <T> Future<T> sendEvent(Event<T> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(MicroService m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregister(MicroService m) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message awaitMessage(MicroService m) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
