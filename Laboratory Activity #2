public class MyBookList {
    public static void main(String[] args) {

        // 1.) Create the following books that contain the title, author, and year published. Use the Book class for this part.
        Book book1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 1997);
        Book book2 = new Book("The Power of Habit", "Charles Duhigg", 2012);
        Book book3 = new Book("Atomic Habits", "James Clear", 2018);
        Book book4 = new Book("Java Programming", "John Doe", 2020);
        Book book5 = new Book("The Alchemist", "Paulo Coelho", 1988); // your favorite book
        Book book6 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999);
        Book book7 = new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007);


        // 2.) Display the details of each book using the displayDetails method.
        book1.displayDetails();
        book2.displayDetails();
        book3.displayDetails();
        book4.displayDetails();
        book5.displayDetails();
        book6.displayDetails();
        book7.displayDetails();


        // 3.) Change the current page of "Rich Dad Poor Dad" to 50 and "Atomic Habits" to 100 using the changePage method. Display details again.
        book1.changePage(50);
        book3.changePage(100);
        System.out.println();
        book1.displayDetails();
        book3.displayDetails();


        // 4.) Change the current page of your favorite book to any page number you like. Display the details again.
        book5.changePage(10000);
        System.out.println();
        book5.displayDetails();


        // 5.) Change the author of "Java Programming" to "Jane Smith". Display the details again.
        book4.setAuthor("Jane Smith");
        System.out.println();
        book4.displayDetails();


        // 6.) Create an array of Book objects to store all the books you created.
        Book[] books = {book1, book2, book3, book4, book5, book6, book7};

        System.out.println("\nBooks published after 2010:");
        for (Book b : books) {
            if (b.getYearPublished() > 2010) {
                System.out.println(b.getTitle());
            }
        }
    }
}
