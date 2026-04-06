package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameManager {
    public void start() {
        List<Car> cars = CarCreator.createCars();
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputNum = Console.readLine();
        int attempts = Integer.parseInt(inputNum);
        if (attempts <= 0 ) {
            throw new IllegalArgumentException ("0이상 입력하세요.");
        }
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