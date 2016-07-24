package pl.btbw.web;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "AsyncReceiver", activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destinationLookup",
				propertyValue = "java:jboss/jms/queue/testQueue"),
		@ActivationConfigProperty(
				propertyName = "destinationType",
				propertyValue = "javax.jms.Queue")
})
public class AsyncReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			String text = ((TextMessage) message).getText();
			System.out.println("Message form Queue: " + text);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
