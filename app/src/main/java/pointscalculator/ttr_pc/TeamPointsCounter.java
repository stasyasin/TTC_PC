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
    static Integer coef1 = 1;
    static Integer coef2 = 2;
    static Integer coef3 = 4;
    static Integer coef4 = 7;
    static Integer coef5 = 15;
    static Integer coef6 = 21;
    int textColor;

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
        this.textColor = Integer.parseInt(inputData.get(10));
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

    public static List<TeamPointsCounter> sortByPoints(List<TeamPointsCounter> inputListObj) {
        List<TeamPointsCounter> sortedList = inputListObj;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - 1; j++) {
                Integer teamPointsResult1 = sortedList.get(j).teamPointsResult;
                Integer teamPointsResult2 = sortedList.get(j + 1).teamPointsResult;
                if (teamPointsResult2 > teamPointsResult1) {
                    TeamPointsCounter temp = sortedList.get(j + 1);
                    sortedList.set(j + 1, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }
}
