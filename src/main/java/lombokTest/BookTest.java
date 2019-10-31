package lombokTest;

public class BookTest {

    public static void main(String[] args) {
        Book book = new Book();
       // System.out.println(book.toString());

        book.setAuthor("s").setId(1).setPrice(11).setUsername("asda");

        System.out.println(book);
    }
}
