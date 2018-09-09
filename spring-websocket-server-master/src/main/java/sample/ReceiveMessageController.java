package sample;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReceiveMessageController {
	
	private String lastReceived = "";

	public String getLastReceived() {
		return lastReceived;
	}
	public void setLastReceived(String lastReceived) {
		this.lastReceived = lastReceived;
	}
	@Autowired
    private SimpMessagingTemplate template;
	@RequestMapping(value="fireMessage", method=RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody String receiveMessage(@RequestBody Message message) {
        System.out.println("Fire "  + message.getFrom() + " " + message.getText());
        System.out.println("Printing time " + lastReceived + " "  + message.getSentTime());
        if(!StringUtils.equalsIgnoreCase(lastReceived.trim(), message.getSentTime().trim()))
        {
        this.lastReceived = message.getSentTime();
        this.template.convertAndSend("/topic/messages", new OutputMessage(message.getFrom(), message.getText(), ""));
        
        try
        {
        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.connect();
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload("Hello world from Java".getBytes());
        client.publish("iot_data", mqttMessage);
        client.disconnect();
        }
        catch(Exception e)
        {
        	System.out.println("Exception caught " + e);
        }
        }
       return "Success";
    }
}
