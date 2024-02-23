import java.util.Objects;

public class Toy {
    private static int toyId = 1;
    private final int id = toyId++;
    private String name;
    private int frequency;
    private int countToy;


    public Toy(String name, int countToy, int frequency) {
        setCountToy(countToy);
        setName(name);
        setFrequency(frequency);
    }


    private void setCountToy(int countToy) {
        if (countToy <= 0) {
            this.countToy = 1;
        } else {
            this.countToy = countToy;
        }
    }

    private void setName(String name) {
        if (Objects.equals(name, " ")) {
            this.name = "None";
        } else {
            this.name = name;
        }

    }

    public void setFrequency(int frequency) {
        if (frequency <= 0) {
            this.frequency = 1;
        } else {
            this.frequency = frequency;
        }

    }

    public int getFrequency() {
        return frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return countToy;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", count=" + getCount() +
                ", frequency=" + getFrequency() +
                '}';
    }
}
