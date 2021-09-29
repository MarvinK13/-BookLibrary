public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("true ist verliehen, false ist verfügbar");

        library.addMember("Jörg");
        library.addMember("Uwe");
        library.addMember("Walther");
        library.addBook("Isch, ein Roman", 69);
        library.addBook("Titanic", 3);
        library.addBook("Rammstein", 9);

        String id = library.giveName("Jörg");
        library.rentBook(id, 69);
        String id2=library.giveName("Uwe");
        library.rentBook(id2,69);
        library.printMembersAndBooks();

        library.giveBookback(id, 9);
        library.printMembersAndBooks();

    }
}
