package org.finance.app.core.domain.events.engine.mocks;


public abstract class AbstractEventReceiver {

    private Boolean eventOccurred = false;
    private Class<?> latestEventType;

    public void handle(Object event) {
        this.latestEventType = event.getClass();
        this.eventOccurred = true;
    }

    public Boolean isRightEventOccurred(){
        boolean result = eventOccurred;
        cleanUpEventShadow();
        return result;
    }

    public void cleanUpEventShadow(){
        this.eventOccurred = false;
    }

}
