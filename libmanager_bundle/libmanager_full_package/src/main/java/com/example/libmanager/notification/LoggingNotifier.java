package com.example.libmanager.notification;

public class LoggingNotifier extends NotifierDecorator {
    public LoggingNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String userId, String message) {
        // comportamento extra: log
        System.out.println("[LOG] Notifying user " + userId + " with message: " + message);
        super.send(userId, message);
    }
}
