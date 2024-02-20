import java.util.HashMap;
import java.util.Queue;

public class Raffle {
    private final int countTickets;
    private final Queue<Toy> prizeToys;
    private final HashMap<Integer, String> prise = new HashMap<>();

    public Raffle(int countTickets, Queue<Toy> prizeToys) {
        this.countTickets = countTickets;
        this.prizeToys = prizeToys;
    }

    private void setPrize() {
        for (int i = 1; i <= countTickets; i++) {
            prise.put(i, prizeToys.poll().getName());
        }
    }

    public HashMap<Integer, String> getPrise() {
        setPrize();
        return prise;
    }
}
