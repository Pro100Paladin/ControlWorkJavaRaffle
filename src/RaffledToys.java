import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class RaffledToys {
    private final ArrayList<Toy> listToys = new ArrayList<>();


    public static void readRaffledToys() throws Exception {
        System.out.printf("В розыгрыше участвуют %d игрушки(ек) \n", MyArrayList.myArrayList().size());
        System.out.println(MyArrayList.myArrayList());
    }

    public static void saveRaffleToys() {
        System.out.println("Введите новую игрушку: ");
        String path = "src/ToysList.txt";
        Scanner newToy = new Scanner(System.in);

        try {
            FileWriter out = new FileWriter(path, true);
            BufferedWriter bufferWriter = new BufferedWriter(out);
            bufferWriter.newLine();
            bufferWriter.write(newToy.next());
            bufferWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public static void deleteRaffleToys(String lineContent)  {
        File file = new File("src/ToysList.txt");
        File temp = new File("_temp_");
        FileWriter save;
        try {
            PrintWriter out = new PrintWriter(new FileWriter(temp), false);
            Files.lines(file.toPath())
                    .filter(line -> !line.contains(lineContent))
                    .forEach(out::println);
            out.close();
            temp.renameTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    ArrayList<Toy> getListToys() throws Exception {
        readRaffledToys();
        return listToys;
    }

}







