import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayList {

    public static ArrayList<Toy> listToys = new ArrayList<>();

    public static ArrayList<String> myArrayList() throws FileNotFoundException {
        Scanner s = new Scanner(new File("src/File/ToysList.txt"));
        ArrayList<String> listToys = new ArrayList<>();
        while (s.hasNext()) {
            listToys.add(s.next());
        }
        s.close();
        return listToys;
    }
    public static void arr(){
        for (Toy listToy : MyArrayList.listToys) {
            System.out.println(listToy);
        }
    }
}
