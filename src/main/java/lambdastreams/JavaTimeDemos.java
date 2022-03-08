package lambdastreams;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;

public class JavaTimeDemos {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.printf("Instance now is %s%n", now);

        Instant then = now.plus(1, ChronoUnit.DAYS);
        Duration elapsed = Duration.between(now, then);
        System.out.printf("Duration after adding 1 day: %s%n", elapsed);
        System.out.printf("Duration in days: %d days%n", elapsed.toDays());
        System.out.printf("Duration in hours: %d hours%n", elapsed.toHours());

        then = now.plus(1, ChronoUnit.DAYS)
                .plus(1, ChronoUnit.HALF_DAYS)
                .plus(1, ChronoUnit.HOURS)
                .plus(10, ChronoUnit.MINUTES)
                .plusSeconds(10)
                .plusMillis(100)
                .plusNanos(100);
        System.out.printf("Adding units to now: %s%n", then);

        LocalDate date1 = LocalDate.now();
        System.out.printf("Local date now: %s%n", date1);

        LocalDate heroDate = LocalDate.of(2022, Month.NOVEMBER, 10);
        System.out.printf("Hero date: %s%n", heroDate);

        LocalDate christmasDate = LocalDate.of(2022, Month.DECEMBER, 25);
        long gap = heroDate.until(christmasDate, ChronoUnit.DAYS);
        System.out.println("There are " + gap + " days between hero date and Christmas");

        Set<String> availableTimeZones = ZoneId.getAvailableZoneIds();
        System.out.println("Total number of time zones: " + availableTimeZones.size());

        availableTimeZones.stream()
                .filter(name -> name.contains("Europe"))
                .forEach(System.out::println);

        ZonedDateTime missing = ZonedDateTime.of(
                LocalDate.of(2016, Month.MARCH, 13),
                LocalTime.of(2, 30),
                ZoneId.of("America/New_York")
        );
        System.out.println(missing);

        ZonedDateTime spring = ZonedDateTime.of(
                2022, 3, 20, 0, 0, 0, 0, ZoneId.systemDefault()
        );
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(spring));
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                .withLocale(Locale.CHINESE);
        System.out.println(formatter.format(spring));

    }
}
