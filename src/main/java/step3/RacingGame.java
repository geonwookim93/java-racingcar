package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 자동차를 가지고 경기(게임)를 하는 클래스
 */
public class RacingGame {

    private int numberOfCar;

    private int numberOfAttempts;

    private int round;

    private List<Car> cars;

    /**
     * 자동차의 갯수를 반환한다.
     *
     * @return
     */
    public int getNumberOfCars() {
        return this.numberOfCar;
    }

    /**
     * 시도 횟수를 반환한다.
     *
     * @return
     */
    public int getNumberOfAttempts() {
        return this.numberOfAttempts;
    }

    /**
     * 현재 진행된 라운드를 반환한다.
     *
     * @return
     */
    public int getRound() {
        return this.round;
    }

    /**
     * 생성자를 설정해 초기화를 한다.
     *
     * @param numberOfCar
     * @param numberOfAttempts
     */
    public RacingGame(int numberOfCar, int numberOfAttempts) {
        this.numberOfCar = numberOfCar;
        this.numberOfAttempts = numberOfAttempts;

        this.round = 0;
        this.cars = this.newRaceCars(numberOfCar);
    }

    /**
     * 자동차 게임에 진행시 사용되는 자동차 목록을 만들어 반환한다.
     *
     * @param numberOfCar
     * @return
     */
    private List<Car> newRaceCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>();

        IntStream.range(0, numberOfCar)
                .forEach(number -> cars.add(new Car()));

        return cars;
    }

    /**
     * 다음 경기 유무를 판별한다.
     *
     * @return
     */
    public boolean hasNextRace() {
        return this.round < this.numberOfAttempts;
    }

    /**
     * 자동차 경기를 진행한다.
     * 정해진 시도 횟수보다 많은 경기가 진행되지 않는다.
     */
    public void racing() {
        // 다음 경기의 유무를 확인해 진행 될 경기가 없는 경우에는 진행하지 않는다.
        if (!this.hasNextRace())
            return;

        for (Car car : this.cars) {
            car.go();
            IntStream.range(0, car.getCurrentPosition())
                    .forEach(number -> System.out.print("-"));
            System.out.println();
        }

        this.round++;
    }

    /**
     * 정해진 시도 횟수 만큼의 모든 경기를 진행한다.
     */
    public void racingAll() {
        while (this.hasNextRace()) {
            this.racing();
        }
    }
}