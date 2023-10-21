package ru.otus.processor;

import ru.otus.model.Message;

import java.time.Clock;
import java.time.LocalDateTime;

public class ProcessorExceptionThrower implements Processor {
    private final Clock clock;

    public ProcessorExceptionThrower() {
        clock = Clock.systemDefaultZone();
    }

    public ProcessorExceptionThrower(Clock clock) {
        this.clock = clock;
    }

    @Override
    public Message process(Message message) {
        int second = LocalDateTime.now(clock).getSecond();
        if (second % 2 == 0) {
            throw new ProcessorException("second is " + second);
        }
        Message newMessage = message.copy();
        System.out.println("ProcessorExceptionThrower is processing message: " + newMessage);
        return newMessage;
    }
}
