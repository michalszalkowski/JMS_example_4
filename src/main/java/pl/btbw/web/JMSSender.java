package pl.btbw.web;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
public class JMSSender {

	@Resource(mappedName = "java:jboss/jms/queue/testQueue")
	private Queue queueExample;

	@Inject
	private JMSContext context;

	public void sendMessage(String txt) {
		try {
			context
					.createProducer()
					.send(queueExample, txt);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}