package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarCreator {
    public static List<Raceable> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        String[] names = inputName.split(",");

        Set<String> nameSet = new HashSet<>(List.of(names));
        if (nameSet.size() != names.length) {
            throw new IllegalArgumentException("중복된 값 입니다.");
        }

        List<Raceable> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}