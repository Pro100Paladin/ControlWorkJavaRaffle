import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class PrizeToys {
    private final ArrayList<Toy> listToys;
    private final Deque<Toy> toyQueue = new LinkedList<>();
    private final ArrayList<Toy> prizeList = new ArrayList<>();
    private final int countTickets;

    public PrizeToys(int countTickets, ArrayList<Toy> listToys) {
        this.countTickets = countTickets;
        this.listToys = listToys;
    }

    private void setToyQueue() {
        double sumFrequencys = 0;
        int sumToys = 0;
        for (Toy t : listToys) {
            sumFrequencys += t.getFrequency();
            sumToys += t.getCount();
        }
        if (sumToys < countTickets) {
            System.out.println("Не хватает игрушек");
        }
        double weightOneFrequency = countTickets / sumFrequencys;
        for (Toy t : listToys) {
            int requiredCount = (int) Math.round(weightOneFrequency * t.getFrequency());
            if (requiredCount < 1) {
                requiredCount = 1;
            }
            if (t.getCount() >= requiredCount) {
                for (int i = 0; i < requiredCount; i++) {
                    prizeList.add(t);
                }
            } else {
                System.out.println("Для корректного розыгрыша не хватает " +
                        (requiredCount - t.getCount()) + " " + t.getName());
            }
        }
        if (prizeList.size() < countTickets) {
            prizeList.add(listToys.get(0));
        }
        Collections.shuffle(prizeList);
        toyQueue.addAll(prizeList);
    }

    public Deque<Toy> getToyQueue() {
        setToyQueue();
        return toyQueue;
    }
}
