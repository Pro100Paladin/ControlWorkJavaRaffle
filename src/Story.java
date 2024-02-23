import java.util.ArrayList;

public class Story {
    private final ArrayList<Toy> listToys = new ArrayList<>();

    private void setListToys() {

        String[] names = {"мяч", "робота", "пазлы", "кубики", "конструктор", "машинка", "кукла", "самолет"};
        int[] numberOfPrizes = {8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < names.length; i++) {
            Toy toy = new Toy(names[i], numberOfPrizes[i] * 10, numberOfPrizes[i]);
            listToys.add(toy);
        }
    }

    ArrayList<Toy> getListToys() {
        setListToys();
        return listToys;
    }
}
