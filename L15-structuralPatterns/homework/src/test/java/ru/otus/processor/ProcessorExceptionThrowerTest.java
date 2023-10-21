package ru.otus.processor;

import org.junit.jupiter.api.Test;
import ru.otus.model.Message;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class ProcessorExceptionThrowerTest {
    private static final String ODD_TIME = "2023-10-21T18:35:01.00Z";
    private static final String EVEN_TIME = "2023-10-21T18:35:02.00Z";

    @Test
    void processOddSecond() {
        var processor = new ProcessorExceptionThrower(Clock.fixed(Instant.parse(ODD_TIME), ZoneId.systemDefault()));
        var message = new Message.Builder(1).build();

        var result = processor.process(message);

        assertEquals(message, result);
    }

    @Test
    void processEvenSecond() {
        var processor = new ProcessorExceptionThrower(Clock.fixed(Instant.parse(EVEN_TIME), ZoneId.systemDefault()));
        final var message = new Message.Builder(1).build();

        var processorException = assertThrowsExactly(ProcessorException.class, () -> processor.process(message));

        assertEquals("second is 2", processorException.getMessage());
    }
}