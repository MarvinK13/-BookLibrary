public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("true ist verliehen, false ist verfügbar");

        library.addMember("Jörg");
        library.addBook("Isch, ein Roman", 69);
        library.addBook("Titanic", 3);

        String id = library.giveName("Jörg");
        library.rentBook(id, 69);
        library.printMembersAndBooks();

        library.giveBookback(id, 69);
        library.printMembersAndBooks();

    }
}
