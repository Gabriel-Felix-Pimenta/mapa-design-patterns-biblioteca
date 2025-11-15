package com.example.libmanager.notification;

public class BasicNotifier implements Notifier {
    @Override
    public void send(String userId, String message) {
        // implementação simples de envio (stub)
        System.out.println("Sending to " + userId + ": " + message);
    }
}
