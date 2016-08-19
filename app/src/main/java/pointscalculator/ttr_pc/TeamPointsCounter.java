package pointscalculator.ttr_pc;

/**
 * Created by Stasyan on 8/19/2016.
 */
public class TeamPointsCounter {
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

    public TeamPointsCounter(String name, String train1, String train2, String train3, String train4, String train5, String train6, String station, String quest, Boolean longestWay) {
        this.name = name;
        this.train1 = train1;
        this.train2 = train2;
        this.train3 = train3;
        this.train4 = train4;
        this.train5 = train5;
        this.train6 = train6;
        this.station = station;
        this.quest = quest;
        this.longestWay = longestWay;
        this.teamPointsResult = parseToInt(train1) * coef1 + parseToInt(train2) * coef2 +
                +parseToInt(train3) * coef3 + parseToInt(train4) * coef4 + parseToInt(train5) * coef5 +
                +parseToInt(train6) * coef6 + parseToInt(station) * 3 + parseToInt(quest);
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
