public class Main {

    public static void main(String[] args) {

        Word[] wordArray = {new Word("Ivan"), new Word("Sverri"),
                new Word("Flødebolle"), new Word("Elefant"), new Word("Skole")};

        Systemos.out.println("Hej");
        Systemos.out.println(5);
        Systemos.out.println(5.00);
        Systemos.out.println(new Word("Kost"));
        Systemos.out.println(new OtherWord("Ivan"));
        Systemos.out.println(wordArray);

        System.out.println();
    }

    /*
    //Sverri løsning
    public static <T> void out(T t) {
        System.out.println(t);
    }
     */
}
