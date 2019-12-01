package exercises;

public class Test extends Lesson{
    private float testPoints[] = new float[5];
    private int testNumber;
    private int index = 0;

    public float[] getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(float testPoints) {
        this.testPoints[index] = testPoints;
        index++;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }
}
