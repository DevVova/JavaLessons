package metanit.oop;

/**
 * Для того чтобы можно было клонировать объект, для этого прежде всего необходимо использовать интерфейс Cloneable.
 */
public class L41_Clone_Objects {
    public static void main(String[] arr) {
        BestBook<String> bestBook = new BestBook<>(new Author<>("Vova"), 2000);

        //Если мы создадим другой объект ссылка которого будет одинаковой с предыдущим объектом, то изменив значение price в одном, изменится значение и в другом.
        BestBook<String> bestBook1 = bestBook;
        bestBook1.setPrice(3000);
        System.out.println(bestBook.getPrice());

        //Чтобы этого избежать нужно не приравнивать ссылки, а создавать клон объекта.
        bestBook1 = bestBook.clone();
        bestBook1.setPrice(4000);
        System.out.println(bestBook.getPrice());//А вот теперь поле price у bestBook не изменится.

        bestBook1.setAuthor(new Author<>("Sam"));
        System.out.println(bestBook1.getAuthor().getName());
    }
}

class BestBook<T> implements Cloneable {
    private Author<T> author;
    private int price;

    public BestBook(Author<T> a, int p) {
        author = a;
        price = p;
    }

    public void setPrice(int pr) {
        price = pr;
    }

    public int getPrice() {
        return price;
    }

    public void setAuthor(Author<T> author) {
        this.author = author;
    }

    public Author<T> getAuthor() {
        return author;
    }

    @Override
    public BestBook<T> clone() {
        try {
            BestBook<T> clone = (BestBook<T>) super.clone();//Ниже в другом классе я написал как с этим предупреждением среды разработки бороться.
            clone.author = author.clone();//А это нужно чтобы при клонировании это поле также клонировалось.
            return clone;
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }
}

class Author<T> implements Cloneable {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public Author(T name) {
        this.name = name;
    }

    @Override
    public Author<T> clone() {
        try {
            @SuppressWarnings("unchecked") // Отключаем предупреждение о небезопасном приведении
            Author<T> clone = (Author<T>) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}