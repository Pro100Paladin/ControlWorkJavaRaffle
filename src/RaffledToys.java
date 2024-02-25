import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class RaffledToys {
    private final ArrayList<Toy> listToys = new ArrayList<>();


    public static void readRaffledToys() throws Exception {
        System.out.printf("В розыгрыше участвуют %d игрушки(ек) \n", MyArrayList.myArrayList().size());
        System.out.println(MyArrayList.myArrayList());
    }

    public static void saveRaffleToys() throws IOException {
        System.out.println("Введите новую игрушку: ");
        String path = "src/File/ToysList.txt";
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
        deletingEmptyLines();
        renameFileToysList();

    }

    public static void deleteRaffleToys(String lineContent) throws IOException {
        File file = new File("src/File/ToysList.txt");
        File temp = new File("_temp_");
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
        deletingEmptyLines();
        renameFileToysList();
    }

    public static void deletingEmptyLines() throws IOException {
        String inputFileName = "src/File/ToysList.txt";
        String outputFileName = "src/File/_temp_";

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
             PrintWriter outputFile = new PrintWriter(new FileWriter(outputFileName))) {
            String lineOfText;
            while ((lineOfText = inputFile.readLine()) != null) {
                lineOfText = lineOfText.trim();
                if (!lineOfText.isEmpty()) {
                    outputFile.println(lineOfText);
                }

            }
        }

    }
    public static void renameFileToysList(){
        Path sourcePath = Paths.get("src/File/_temp_");
        Path destinationPath = Paths.get("src/File/ToysList.txt");
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Ошибка! Возникло исключение: " + e.getMessage());
        }
    }

    ArrayList<Toy> getListToys() throws Exception {
        readRaffledToys();
        return listToys;

    }
}







