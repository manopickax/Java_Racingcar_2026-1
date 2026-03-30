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
        if (name == null || name.isBlank() ||  name.length() > 5 || name.contains(" ")) {
            throw new IllegalArgumentException ("올바른 값을 입력해주세요. (문자열을 입력하세요.)");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance ++;
        }
    }

    public void printStatus() {
        System.out.println(name + " : " + "-".repeat(distance));
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}

class GameManager {
    public void start() {
        List<Car> cars = createCars();
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputNum = Console.readLine();
        int attempts = Integer.parseInt(inputNum);
        if (attempts <= 0 ) {
            throw new IllegalArgumentException ("0이상 입력하세요.");
        }
        for(int i = 1; i <= attempts; i++){
            for (Car car : cars){
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.move(randomNumber);
                car.printStatus();
            }
            System.out.println();
            System.out.println("실행 결과");
        }
        WinnerPicker winnerPicker = new WinnerPicker();
        winnerPicker.pirntWinner(cars);
    }

    private static List<Car> createCars() {
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

class WinnerPicker {
    public void pirntWinner(List<Car> cars) {
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