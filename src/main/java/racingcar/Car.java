package racingcar;

public class Car {
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
