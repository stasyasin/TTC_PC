package pointscalculator.ttr_pc;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stasyan on 8/19/2016.
 */
public class TeamPointsCounter implements Serializable {
    String name;
    String train1;
    String train2;
    String train3;
    String train4;
    String train5;
    String train6;
    String station;
    String quest;
    Boolean longestWay;
    Integer teamPointsResult;
    Integer coef1 = 1;
    Integer coef2 = 2;
    Integer coef3 = 4;
    Integer coef4 = 7;
    Integer coef5 = 15;
    Integer coef6 = 21;

    public TeamPointsCounter(List<String> inputData) {
        this.name = inputData.get(0);
        this.train1 = inputData.get(1);
        this.train2 = inputData.get(2);
        this.train3 = inputData.get(3);
        this.train4 = inputData.get(4);
        this.train5 = inputData.get(5);
        this.train6 = inputData.get(6);
        this.station = inputData.get(7);
        this.quest = inputData.get(8);
        this.longestWay = Boolean.parseBoolean(inputData.get(9));
        this.teamPointsResult = parseToInt(train1) * coef1 + parseToInt(train2) * coef2 +
                +parseToInt(train3) * coef3 + parseToInt(train4) * coef4 + parseToInt(train5) * coef5 +
                +parseToInt(train6) * coef6 + parseToInt(station) * 4 + parseToInt(quest);
        if (longestWay) {
            this.teamPointsResult = this.teamPointsResult + 10;
        }
    }

    private Integer parseToInt(String parseString) {
        Integer parseInt = 0;
        try {
            parseInt = Integer.parseInt(parseString);
        } catch (Exception e) {
            parseInt = null;
        }
        return parseInt;
    }
}
