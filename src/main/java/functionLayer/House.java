package functionLayer;

public class House {

    private final int height;
    private final int length;
    private final int width;
    private final int frontSide1x2;
    private final int frontSide2x2;
    private final int frontSide4x2;

    private final int backSide1x2;
    private final int backSide2x2;
    private final int backSide4x2;

    private final int gables1x2;
    private final int gables2x2;
    private final int gables4x2;

    private final CalculatorLogicFacade calculator = new CalculatorLogicFacade();

    public House(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;

        frontSide1x2 = calculator.frontSide1x2(height, length);
        frontSide2x2 = calculator.frontSide2x2(height, length);
        frontSide4x2 = calculator.frontSide4x2(height, length);

        backSide1x2 = calculator.backSide1x2(height, length);
        backSide2x2 = calculator.backSide2x2(height, length);
        backSide4x2 = calculator.backSide4x2(height, length);

        gables1x2 = calculator.gables1x2(height, width);
        gables2x2 = calculator.gables2x2(height, width);
        gables4x2 = calculator.gables4x2(height, width);

    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getFrontSide1x2() {
        return frontSide1x2;
    }

    public int getFrontSide2x2() {
        return frontSide2x2;
    }

    public int getFrontSide4x2() {
        return frontSide4x2;
    }

    public int getBackSide1x2() {
        return backSide1x2;
    }

    public int getBackSide2x2() {
        return backSide2x2;
    }

    public int getBackSide4x2() {
        return backSide4x2;
    }

    public int getGables1x2() {
        return gables1x2;
    }

    public int getGables2x2() {
        return gables2x2;
    }

    public int getGables4x2() {
        return gables4x2;
    }

    public int getAll1x2() {
        return frontSide1x2 + backSide1x2 + gables1x2;
    }
    
    public int getAll2x2() {
        return frontSide2x2 + backSide2x2 + gables2x2;
    }

    public int getAll4x2() {
        return frontSide4x2 + backSide4x2 + gables4x2;
    }
}
