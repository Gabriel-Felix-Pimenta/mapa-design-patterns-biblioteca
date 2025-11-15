package com.example.libmanager.notification;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotifierDecoratorTest {

    @Test
    void shouldLogAndSendMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Notifier notifier = new LoggingNotifier(new BasicNotifier());
        notifier.send("user1", "Hello!");

        String log = output.toString();

        assertTrue(log.contains("[LOG]"));
        assertTrue(log.contains("Sending to user1"));
    }
}

