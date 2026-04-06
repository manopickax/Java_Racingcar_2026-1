package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerPicker {
    public void printWinner(List<Car> cars) {
        int maxdistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxdistance) {
                maxdistance = car.getDistance();
            }
        }

        List<String> winnercars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxdistance) {
                winnercars.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnercars));
    }
}
