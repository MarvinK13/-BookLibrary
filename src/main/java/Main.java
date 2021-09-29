public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        library.addMember("Jörg");
        library.addBook("Isch, ein Roman",69);
        library.giveName("Jörg");

        library.printMembersAndBooks();

    }
}
