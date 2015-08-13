package ru.codeunited.messagebridge;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 28.06.15.
 */
@Component
public class JustViewProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
    }

}
