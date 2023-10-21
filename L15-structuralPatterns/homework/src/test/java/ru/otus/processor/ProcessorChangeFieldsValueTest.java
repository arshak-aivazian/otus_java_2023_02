package ru.otus.processor;

import org.junit.jupiter.api.Test;
import ru.otus.model.Message;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorChangeFieldsValueTest {
    private static final Long ID = 1l;
    private static final String FIELD_11 = "value11";
    private static final String FIELD_12 = "value12";

    @Test
    void process() {

        var message = new Message.Builder(ID)
                .field11(FIELD_11)
                .field12(FIELD_12)
                .build();
        var processor = new ProcessorSwapFieldsValue();

        var result = processor.process(message);

        assertEquals(ID, result.getId());
        assertEquals(FIELD_11, result.getField12());
        assertEquals(FIELD_12, result.getField11());
    }
}