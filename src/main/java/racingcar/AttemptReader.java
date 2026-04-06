package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class AttemptReader {
    public static int read() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputNum = Console.readLine();
        int attempts = Integer.parseInt(inputNum);
        if (attempts <= 0 ) {
            throw new IllegalArgumentException ("0이상 입력하세요.");
        }
        return attempts;
    }
}
