package org.example;

import org.example.junit5.LoggingUtils;
import org.example.util.Attachment;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.example.util.AttachmentHelper.FILE_NAME;
import static org.example.util.AttachmentHelper.getFileFromResources;


//@Slf4j
public class LogTest extends TestBase {
    private final Logger log = LoggerFactory.getLogger(LogTest.class);
    @Test
    void logTest() {
        log.trace("Trace level log");
        log.debug("Debug level log");
        log.info("Info level log");
        log.warn("Warn level log");
        log.error("Error level log");
        throw new IllegalArgumentException("Critical exception");
    }

    @Test
    void logWithAttachmentTest() {
        Arrays.stream(Attachment.values()).forEach(it -> {
            LoggingUtils.log(getFileFromResources(FILE_NAME, it.getExtension()),
                    String.format("I'm logging content via temp %s file", it.name()));
        });
    }
}
