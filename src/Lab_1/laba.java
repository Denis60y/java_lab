package Lab_1;

public class laba {
    public static void main(String[] args) {
        final int       MILLISECONDS_PER_SECOND     = 1000; // 1 секунда содержит 1000 миллисекунд
        final int       SECONDS_PER_MINUTE          = 60; // 1 минута содержит 60 секунд
        final int       MINUTES_PER_HOUR            = 60; // 1 час содержит 60 минут
        final int       HOURS_PER_DAY               = 24; // 1 сутки содержат 24 часа

        long totalMilliseconds = System.currentTimeMillis();
        long currentHour; // текущее кол во часов по Гринвичу
        long currentMinute; // текущее кол// текущее кол--во минутво минут
        long currentSecond; // текущее кол// текущее кол--во секундво секунд

        long totalSeconds; // общее кол во секунд, прошедших с 00:00:00 GMT 01/01/1970
        long totalMinutes; // общее кол во минут, прошедших с 00:00:00 GMT 01/01/1970
        long totalHours; // общее кол во часов, прошедших с 00:00:00 GMT 01/01/1970


        //totalSeconds = totalNanoseconds / NANOSECONDS_PER_SECOND;
        totalSeconds = totalMilliseconds / MILLISECONDS_PER_SECOND;
        currentSecond = totalSeconds % SECONDS_PER_MINUTE;
        totalMinutes = totalSeconds / SECONDS_PER_MINUTE;
        currentMinute = totalMinutes % MINUTES_PER_HOUR;
        totalHours = totalMinutes / MINUTES_PER_HOUR;
        currentHour = totalHours % HOURS_PER_DAY;

        System.out.println("Текущее время равно " + currentHour + ":"
        + currentMinute + ":" + currentSecond + "GMT");
    }
}
