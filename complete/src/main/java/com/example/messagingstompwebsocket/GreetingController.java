package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController{
    
    
    @MessageMapping("/hello") //MessageMappping
    @SendTo("/topic/greetings") //해당 주소로 보냅니다.
    public Greeting greeting(HelloMessage message) throws Exception{
        Thread.sleep(500); // simulated delay //0.5sec
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"); //메시지를 받음녀 Hello,  받은 메시지의 getName으로 전송
    }
    
}
