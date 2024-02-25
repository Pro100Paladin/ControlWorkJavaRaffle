import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        RaffledToys.deletingEmptyLines();
        RaffledToys.renameFileToysList();
        myMenu.menu();
    }
}