import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Story {
    private final ArrayList<Toy> listToys = new ArrayList<>();

    private void setListToys() throws FileNotFoundException {
        File txt = new File("src/File/ToysList.txt");
        Scanner scan = new Scanner(txt);
        ArrayList<String> data = new ArrayList<>() ;
        while(scan.hasNextLine()){
            data.add(scan.nextLine());
        }
        System.out.println(data);
        String[] names = data.toArray(new String[]{});
        int[] numberOfPrizes = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < names.length; i++) {
            Toy toy = new Toy(names[i], numberOfPrizes[i]*5, numberOfPrizes[i]*3);
            listToys.add(toy);
        }
    }

    ArrayList<Toy> getListToys() throws FileNotFoundException {
        setListToys();
        return listToys;
    }
}
