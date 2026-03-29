package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.start();
    }
}

class Car {
    private final String name;
    private int distance = 0;

    public Car (String name) {
        validateName(name);
        this.name = name;
    }
    private void validateName(String name){
        if (name == null || name.isBlank() ||  name.length() > 5) {
            throw new IllegalArgumentException ("올바른 값을 입력해주세요. (문자열을 입력하세요.)");
        }
    }
    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance ++;
        }
    }
    public void printStatus() {
        System.out.println(name + " : " + " - ".repeat(distance));
    }
}

class GameManager {
    public void start() {
        List<Car> cars = createCars();
        System.out.println("시도할 회수");
        String inputNum = Console.readLine();
        int attempts = Integer.parseInt(inputNum);
        if (attempts <= 0 ) {
            throw new IllegalArgumentException ("0이상 입력하세요.");
        }
        for(int i = 1; i <= attempts; i++){
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            for (Car car : cars){
                car.move(randomNumber);
                car.printStatus();
            }
            System.out.println(" ");
        }

    }
    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        String[] names = inputName.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}

class WinnerPicker {

}