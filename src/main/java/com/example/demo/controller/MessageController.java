package com.example.demo.controller;

import com.example.demo.beans.MessageData;
import com.example.demo.converter.MessageConverterUtils;
import com.example.demo.printer.ConsolePrint;
import com.example.demo.printer.IPrinter;
import com.example.demo.printer.PrinterType;
import com.example.demo.validator.MessageTypeDecider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class MessageController {
    private static volatile double sum = 0;
    private static Map<PrinterType, IPrinter> printersMap = new HashMap<>();

    @Value("${app.printer.type.console}")
    private PrinterType printerType;

    static {
        printersMap.put(PrinterType.CONSOLE, new ConsolePrint());
    }

    @PostMapping("handleMessage")
    public ResponseEntity<String> handleMessage(@RequestBody(required = false) String value) {
        if (value == null) {
            return new ResponseEntity<>("value is null", HttpStatus.NO_CONTENT);
        } else {
            printMessage(MessageConverterUtils.convertMessage(MessageTypeDecider
                    .getMessageType(value), value), printerType);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
    }

    private void printMessage(MessageData messageData, PrinterType printerType) {
        IPrinter printer = printersMap.get(printerType);
        if (printer != null) {
            sum += messageData.getNumberValue();
            printer.print(messageData, sum);
        } else {
            log.error("No printer found");
        }
    }
}
