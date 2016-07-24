package pl.btbw.web;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class MyCtrl {

	@Inject
	private JMSSender jmsSender;

	@GET
	@Path("/send/{message}")
	public String sendMessage(@PathParam("message") String message) {
		jmsSender.sendMessage(message);
		return "sent message: " + message;
	}

}
