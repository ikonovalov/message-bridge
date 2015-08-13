package ru.codeunited.messagebridge;

import org.apache.camel.spring.Main;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 27.06.15.
 */
public class MessageBridge {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setApplicationContextUri("message-bridge.xml");
        main.enableHangupSupport();
        main.run(args);
    }
}
