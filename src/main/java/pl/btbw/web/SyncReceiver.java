package pl.btbw.web;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class SyncReceiver {

	@Resource(mappedName = "java:jboss/jms/queue/testQueue")
	private Queue queueExample;

	@Inject
	private JMSContext context;

	public String startReceiver() {
		return context
				.createConsumer(queueExample)
				.receiveBody(String.class);
	}
}
