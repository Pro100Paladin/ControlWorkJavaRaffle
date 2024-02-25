import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class myMenu {

    public static void menu() throws Exception {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";

        while (!"5".equals(s)) {
            System.out.println("провести розыгрыш - 1");
            System.out.println("добавить игрушку в список - 2");
            System.out.println("удалить игрушку из списка - 3");
            System.out.println("посмотреть список игрушек - 4");
            System.out.println("выход из меню - 5");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не верную команду");
            }
            switch (x) {
                case 1:
                    System.out.println("введи количество участвующих билетов:");
                    int countTickets = Integer.parseInt(MyScanner.scanner());
                    System.out.printf("В розыгрыше участвуют %d игрушки(ек) \n", MyArrayList.myArrayList().size());
                    String fileName = "src/File/Result.txt";
                    Story story = new Story();
                    PrizeToys prizeToys = new PrizeToys(countTickets, story.getListToys());
                    Raffle raffle = new Raffle(countTickets, prizeToys.getToyQueue());
                    HashMap<Integer, String> mapResult = raffle.getPrise();
                    Result result = new Result(mapResult, fileName);
                    result.write();
                    break;
                case 2:
                    RaffledToys.saveRaffleToys();
                    break;
                case 3:
                    System.out.println("введите название игрушки которую необходимо удалить");
                    RaffledToys.readRaffledToys();
                    RaffledToys.deleteRaffleToys(MyScanner.scanner());
                    System.out.println("Вы удалили игрушку:\n");
                    break;
                case 4:
                    RaffledToys.readRaffledToys();
                    System.out.println();
                    break;
            }
        }
        System.out.println("до свидания!");
        System.out.println();
    }
}

