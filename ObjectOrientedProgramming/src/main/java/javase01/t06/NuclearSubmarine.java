package javase01.t06;

import java.util.Random;

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
