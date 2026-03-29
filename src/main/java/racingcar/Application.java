package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        List<Car> cars = createCars();
    }

    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}

class Car {
    private final String name;
    private int distance = 0;
    int randomNumber = Randoms.pickNumberInRange(0, 9);

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

}
