import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Result {
    private final HashMap<Integer, String> mapResult;
    private final String fileName;

    public Result(HashMap<Integer, String> mapResult, String fileName) {
        this.mapResult = mapResult;
        this.fileName = fileName;
    }

    public void write() {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Integer k : mapResult.keySet()) {
                fileWriter.write("Билет № " + k + " выиграл " + mapResult.get(k) + ".\n");
            }
            System.out.println("Результаты розыгрыша записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
}
