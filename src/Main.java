import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int countTickets = 15;
        String fileName = "src/ResultRaffle.txt";
        Story story = new Story();
        PrizeToys prizeToys = new PrizeToys(countTickets, story.getListToys());
        Raffle raffle = new Raffle(countTickets, prizeToys.getToyQueue());
        HashMap<Integer, String> mapResult = raffle.getPrise();
        Result result = new Result(mapResult, fileName);
        result.write();

    }
}