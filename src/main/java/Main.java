public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("true ist verliehen, false ist verfügbar | geliehen von 0 ist auch nicht geliehen");

        library.addMember("Jörg");
        library.addMember("Uwe");
        library.addMember("Walther");

        library.addBook("Isch, ein Roman", 69);
        library.addBook("Titanic", 3);
        library.addBook("Rammstein", 9);
        library.printMembersAndBooks();

        int id = library.giveIdFromUsers("Jörg");
        library.rentBook(id, 69);
        int id2 = library.giveIdFromUsers("Uwe");
        library.rentBook(id2, 9);
        library.printMembersAndBooks();

        library.giveBookback(id, 69);
        library.printMembersAndBooks();

    }
}
