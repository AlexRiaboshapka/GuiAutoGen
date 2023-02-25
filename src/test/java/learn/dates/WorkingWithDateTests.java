package learn.dates;

import logger.CustomLogger;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WorkingWithDateTests {
    @Test
    public void localDate(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDateMinusThreeDays = localDate.minus(3, ChronoUnit.DAYS);
        CustomLogger.logger.info(localDateMinusThreeDays);
    }

    @Test
    public void localTime(){
        LocalDateTime localDate = LocalDateTime.now();
        LocalDateTime localDateMinusThreeDays = localDate.minus(3, ChronoUnit.DAYS);
        CustomLogger.logger.info(localDateMinusThreeDays);
    }
}
