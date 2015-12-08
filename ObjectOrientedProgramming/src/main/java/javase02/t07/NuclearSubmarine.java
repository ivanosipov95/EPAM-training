package javase02.t07;

@MyAnnotation(author = "Osipov Ivan", date = "08.12.2015")
public class NuclearSubmarine {

    private String name;

    public NuclearSubmarine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class EngineForTheSubmarine {

        private int power;

        public EngineForTheSubmarine(int power) {
            this.power = power;
        }

        public EngineForTheSubmarine() {
            power = 1000;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public void run() {
            System.out.println("Двигатель запущен!");
        }
    }

    public void sail() {
        new EngineForTheSubmarine().run();
        System.out.println("Полный вперед!!");
    }
}
