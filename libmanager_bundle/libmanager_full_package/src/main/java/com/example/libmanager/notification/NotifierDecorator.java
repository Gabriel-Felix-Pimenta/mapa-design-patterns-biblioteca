package com.example.libmanager.notification;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;
    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }
    @Override
    public void send(String userId, String message) {
        wrappee.send(userId, message);
    }
}
