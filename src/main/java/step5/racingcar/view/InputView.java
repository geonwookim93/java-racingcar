package step5.racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public String[] getCarNames(String instructionMessage) {
        System.out.println(instructionMessage);
        String[] carNames = scanner.next().split(SEPARATOR);
        return carNames;
    }

    public int getGameTryCounts(String instructionMessage) {
        System.out.println(instructionMessage);
        int userInput = scanner.nextInt();
        return userInput;
    }
}