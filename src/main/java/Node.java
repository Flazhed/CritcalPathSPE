/**
 * Created by Flashed on 18-05-2017.
 */
public class Node {

    private String name;
    private int duration;
    private int earlyStart;
    private int earlyFinish;
    private int lateStart;
    private int lateFinish;

    public Node(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getLateStart() {
        return lateStart;
    }

    public void setLateStart(int lateStart) {
        this.lateStart = lateStart;
    }

    public int getLateFinish() {
        return lateFinish;
    }

    public void setLateFinish(int lateFinish) {
        this.lateFinish = lateFinish;
    }

    public int getDuration() {

        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEarlyStart() {
        return earlyStart;
    }

    public void setEarlyStart(int earlyStart) {
        this.earlyStart = earlyStart;
    }

    public int getEarlyFinish() {
        return earlyFinish;
    }

    public void setEarlyFinish(int earlyFinish) {
        this.earlyFinish = earlyFinish;
    }
}
