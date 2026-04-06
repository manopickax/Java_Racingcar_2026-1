package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerPicker {
    public void printWinner(List<Raceable> cars) {
        int maxdistance = 0;
        for (Raceable car : cars) {
            if (car.getDistance() > maxdistance) {
                maxdistance = car.getDistance();
            }
        }

        List<String> winnercars = new ArrayList<>();
        for (Raceable car : cars) {
            if (car.getDistance() == maxdistance) {
                winnercars.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnercars));
    }
}
