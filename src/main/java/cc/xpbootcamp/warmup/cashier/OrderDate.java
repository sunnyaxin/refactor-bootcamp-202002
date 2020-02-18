package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.Month;

class OrderTime {
    private int year;
    private Month month;
    private int date;
    private DayOfWeek weekDay;

    OrderTime(int year, Month month, int date, DayOfWeek weekDay) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.weekDay = weekDay;
    }

    int getYear() {
        return year;
    }

    Month getMonth() {
        return month;
    }

    int getDate() {
        return date;
    }

    DayOfWeek getWeekDay() {
        return weekDay;
    }
}
