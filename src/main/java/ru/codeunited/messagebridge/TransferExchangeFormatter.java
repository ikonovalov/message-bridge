package ru.codeunited.messagebridge;

import com.google.common.base.Joiner;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.spi.ExchangeFormatter;
import org.springframework.stereotype.Component;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 10.08.15.
 */
@Component
public class TransferExchangeFormatter implements ExchangeFormatter {

    private static final char COLUMN_SEPARATOR = ';';

    private String additionalHeader;

    public static char getColumnSeparator() {
        return COLUMN_SEPARATOR;
    }

    public String getAdditionalHeader() {
        return additionalHeader;
    }

    public void setAdditionalHeader(String additionalHeader) {
        this.additionalHeader = additionalHeader;
    }

    public String format(Exchange exchange) {
        final Message message = exchange.getIn();
        return Joiner.on(COLUMN_SEPARATOR).join(
                message.getHeader(Exchange.BREADCRUMB_ID, "-", String.class),
                message.getHeader("rabbitmq.EXCHANGE_NAME", "-", String.class),
                message.getHeader("JMSMessageID", "-", String.class),
                getAdditionalHeader() == null ? "" : message.getHeader(getAdditionalHeader(), "", String.class)
        );
    }
}
