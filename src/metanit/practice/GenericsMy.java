package metanit.practice;

public class GenericsMy {
    public static void main(String[] args) {
        AndroidApp<Integer, String> app = new AndroidApp<>(100000, "red");
        System.out.println(app.voice());
    }
}

class App<T> {
    private T price;

    public App(T p) {
        price = p;
    }

    public void setPrice(T pr) {
        this.price = pr;
    }
}

class AndroidApp<T, S extends String> extends App<T> implements Voice<String>{
    private S color;

    public AndroidApp(T pr, S col) {
        super(pr);
        color = col;
    }

    public void setColor(S color) {
        this.color = color;
    }

    @Override
    public String voice() {
        return color;
    }
}

interface Voice<T> {
    T voice();
}