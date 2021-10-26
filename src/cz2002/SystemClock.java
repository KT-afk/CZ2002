package cz2002;

import java.time.LocalDateTime;

public final class SystemClock {
    private static long startTime;
    private static LocalDateTime currentDateTime;

    static  {
        startTime = System.nanoTime();
        currentDateTime = LocalDateTime.now();
    }

    public static void SetDateTime(LocalDateTime newDateTime) {
        currentDateTime = newDateTime;
        startTime = System.nanoTime();
    }

    public static LocalDateTime GetCurrentDateTime() {
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        currentDateTime = currentDateTime.plusNanos(timeElapsed);
        return currentDateTime;
    }
}
