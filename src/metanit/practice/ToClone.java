package metanit.practice;

public class ToClone {
    public static void main(String[] args) {
        Home home = new Home(new Thing(340));
        Home home1 = home.clone();
        System.out.println(home1.thing.price);
    }
}

class Thing implements Cloneable {
    int price;

    public Thing(int pr) {
        price = pr;
    }

    @Override
    public Thing clone() {
        try{
            return (Thing) super.clone();
        } catch(CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }
}

class Home implements Cloneable{
    int price;
    Thing thing;

    public Home(Thing th) {
        thing = th;
    }

    @Override
    public Home clone() {
        try{
            Home clone = (Home) super.clone();// Создаем поверхностную копию объекта Home. Так правильнее.
            clone.thing = this.thing.clone();
            return clone;
        }catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }
}