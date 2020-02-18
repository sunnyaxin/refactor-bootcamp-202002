package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.Month;

class OrderDate {
    private int year;
    private Month month;
    private int day;
    private DayOfWeek weekDay;

    OrderDate(int year, Month month, int day, DayOfWeek weekDay) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.weekDay = weekDay;
    }

    int getYear() {
        return year;
    }

    Month getMonth() {
        return month;
    }

    int getDay() {
        return day;
    }

    DayOfWeek getWeekDay() {
        return weekDay;
    }
}
