package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameManager {
    public void start() {
        List<Car> cars = CarCreator.createCars();
        int attempts = AttemptReader.read();

        System.out.println();
        System.out.println("실행 결과");
        for(int i = 1; i <= attempts; i++){
            for (Car car : cars){
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.move(randomNumber);
                car.printStatus();
            }
            System.out.println();
        }
        WinnerPicker winnerPicker = new WinnerPicker();
        winnerPicker.printWinner(cars);
    }
}