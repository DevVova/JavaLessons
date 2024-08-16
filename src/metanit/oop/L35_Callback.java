package metanit.oop;

/**
 * Суть обратного вызова состоит в том, что мы создаем действия, которые вызываются
 * при других действиях. То есть одни действия вызываются другими действиями. Стандартный
 * пример - нажатие на кнопку. Когда мы нажимаем на кнопку, мы производим действие, но
 * в ответ на это нажатие запускаются другие действия. Например, нажатие на значок принтера
 * запускает печать документа на принтере и т.д.
 */
public class L35_Callback {
    public static void main(String[] args) {
        AlarmClock myClock = new AlarmClock(new LoudAlarm());
        myClock.wakeup();

        //Ниже мы ссылаемся на другой объект, таким образом у нас изменяется wakeup.
        myClock = new AlarmClock(new QuietAlarm());
        myClock.wakeup();

        AlarmClock2 clock = new AlarmClock2();
        clock.setAlarm(new LoudAlarm());
        clock.wakeup();
        clock.setAlarm(new QuietAlarm());
        clock.wakeup();
    }
}

interface Alarm {
    void ring();
}

class QuietAlarm implements Alarm {
    @Override
    public void ring() {
        System.out.println("Alarm is quiet.");
    }
}

class LoudAlarm implements Alarm {
    @Override
    public void ring() {
        System.out.println("Alarm is loud.");
    }
}

class AlarmClock {
    private Alarm alarm;

    //Значение верхнего поля будет зависеть от переданного значения в конструкторе. Так избежим NullPointerException.
    public AlarmClock(Alarm alarm) {
        this.alarm = alarm;
    }

    public void wakeup() {
        System.out.print("Wakeup! ");
        alarm.ring();
    }
}

class AlarmClock2 {
    private Alarm alarm;

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public void wakeup() {
        if (alarm != null) {
            alarm.ring();
        }
    }
}