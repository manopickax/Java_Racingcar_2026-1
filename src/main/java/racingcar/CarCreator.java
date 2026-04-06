package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {
    public static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        String[] names = inputName.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
            for (int i = 0; i < cars.size(); i++) {
                for (int j = i + 1; j < cars.size(); j++) {
                    if (cars.get(i).getName().equals(cars.get(j).getName())) {
                        throw new IllegalArgumentException("중복된 값 입니다.");
                    }
                }
            }
        }
        return cars;
    }
}
