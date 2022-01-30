package devon.oneday.guid.generator.server.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final String NANO_FORMATTER = "yyyyMMddHHmmssSSSSSS";

    public static String getCurrentNanoDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(NANO_FORMATTER));
    }

}
