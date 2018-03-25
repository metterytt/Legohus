package functionLayer;

public class CalculatorLogicFacade {

    public int frontSide1x2(int height, int length) {
        if (length % 2 == 0 && ((length - 2) / 2) % 2 != 0) {
            return 6;
        } else if (length % 2 == 0 && ((length - 2) / 2) % 2 == 0) {
            return 0;
        } else {
            return 3 + (height - 3);
        }
    }

    public int frontSide2x2(int height, int length) {
        int brickCount;
        if (length % 2 == 0) {
            // for each side of door, thus *2:
            brickCount = (((((length / 2 - 1) % 4)) / 2) * 2 + (((length / 2 - 3) % 4) / 2)) * 2;
            // for area overhead door:
            if (height % 2 == 0) {   //((height - 3) / 2 + height % 2);
                brickCount += (((length % 4) / 2) * (height - 3) / 2) + (((length - 4) % 4) / 2) * (((height - 3) / 2) + 1);
            } else {
                brickCount += (((length % 4) / 2) * (height - 3) / 2) + (((length - 4) % 4) / 2) * ((height - 3) / 2);
            }
            return brickCount;
        } else {
            // for one side of door:
            brickCount = (length / 2) % 4 + ((length / 2 - 2) % 4) / 2;
            // for other side of door:
            brickCount += (length / 2 - 2) % 4 + ((length / 2 - 4) % 4) / 2;
            // for area overhead door:
            if (height % 2 == 0) {
                brickCount += (((length - 1) % 4) / 2) * ((height - 3) / 2) + (((length - 5) % 4) / 2) * (((height - 3) / 2) + 1);
            } else {
                brickCount += (((length - 1) % 4) / 2) * ((height - 3) / 2) + (((length - 5) % 4) / 2) * ((height - 3) / 2);
            }
            return brickCount;
        }
    }

    public int frontSide4x2(int height, int length) {
        int brickCount;
        if (length % 2 == 0) {
            // for each side of door, thus *2:
            brickCount = (((length / 2 - 1) / 4) * 2 + ((length / 2 - 3) / 4)) * 2;
            // for area overhead door:
            if (height % 2 == 0) {
                brickCount += length / 4 * ((height - 3) / 2) + ((length - 4) / 4) * (((height - 3) / 2) + 1);
            } else {
                brickCount += length / 4 * ((height - 3) / 2) + ((length - 4) / 4) * ((height - 3) / 2);
            }
            return brickCount;
        } else {
            // for one side of door:
            brickCount = ((length / 2) / 4) * 2 + (length / 2 - 2) / 4;
            // for other side of door:
            brickCount += ((length / 2 - 1) / 4) * 2 + (length / 2 - 3) / 4;
            // for area overhead door:
            if (height % 2 == 0) {
                brickCount += (length - 1) / 4 * ((height - 3) / 2) + ((length - 5) / 4) * (((height - 3) / 2) + 1);
            } else {
                brickCount += (length - 1) / 4 * ((height - 3) / 2) + ((length - 5) / 4) * ((height - 3) / 2);
            }
            return brickCount;
        }
    }

    public int backSide1x2(int height, int length) {
        if (length % 2 == 0 && ((length - 2) / 2) % 2 != 0) {
            return 4;
        } else if (length % 2 == 0 && ((length - 2) / 2) % 2 == 0) {
            return 0;
        } else {
            return 2 + (height - 2);
        }
    }

    public int backSide2x2(int height, int length) {
        int brickCount;
        if (length % 2 == 0) {
            // for each side of window, thus *2:
            brickCount = (((((length / 2 - 1) % 4)) / 2) + (((length / 2 - 3) % 4) / 2)) * 2;
            // for area overhead window:
            if (height % 2 == 0) {
                brickCount += (((length % 4) / 2) * (height - 2) / 2) + (((length - 4) % 4) / 2) * ((height - 2) / 2);
            } else {
                brickCount += (((length % 4) / 2) * (height - 2) / 2) + (((length - 4) % 4) / 2) * (((height - 2) / 2) + 1);
            }
            return brickCount;
        } else {
            // for one side of window: 
            brickCount = ((length / 2) % 4) / 2 + ((length / 2 - 2) % 4) / 2;
            // for other side of window:
            brickCount += ((length / 2 - 2) % 4) / 2 + ((length / 2 - 4) % 4) / 2;
            // for area overhead window:
            if (height % 2 == 0) {
                brickCount += (((length - 1) % 4) / 2) * ((height - 2) / 2) + (((length - 5) % 4) / 2) * ((height - 2) / 2);
            } else {
                brickCount += (((length - 1) % 4) / 2) * ((height - 2) / 2) + (((length - 5) % 4) / 2) * (((height - 2) / 2) + 1);
            }
            return brickCount;
        }
    }

    public int backSide4x2(int height, int length) {
        int brickCount;
        if (length % 2 == 0) {
            // for each side of window, thus *2:
            brickCount = (((length / 2 - 1) / 4) + ((length / 2 - 3) / 4)) * 2;
            // for area overhead window:
            if (height % 2 == 0) {
                brickCount += length / 4 * ((height - 2) / 2) + ((length - 4) / 4) * ((height - 2) / 2);
            } else {
                brickCount += length / 4 * ((height - 2) / 2) + ((length - 4) / 4) * (((height - 2) / 2) + 1);
            }
            return brickCount;
        } else {
            // for one side of window:
            brickCount = ((length / 2) / 4) + (length / 2 - 2) / 4;
            // for other side of window:
            brickCount += ((length / 2 - 1) / 4) + (length / 2 - 3) / 4;
            // for area overhead window:
            if (height % 2 == 0) {
                brickCount += (length - 1) / 4 * ((height - 2) / 2) + ((length - 5) / 4) * ((height - 3) / 2);
            } else {
                brickCount += (length - 1) / 4 * ((height - 2) / 2) + ((length - 5) / 4) * (((height - 3) / 2) + 1);
            }
            return brickCount;
        }
    }

    public int gables1x2(int height, int width) {
        if (width % 2 == 0) {
            return 0;
        } else {
            return height;
        }
    }

    public int gables2x2(int height, int width) {
        int brickCount = ((((width - 4) % 4) / 2) * 2) * (height / 2 + height % 2);
        brickCount += ((((width % 4) / 2)) * 2) * (height / 2);
        return brickCount * 2;
    }

    public int gables4x2(int height, int width) {
        int brickCount = (((width - 4) / 4)) * (height / 2 + height % 2);
        brickCount += (width / 4) * (height / 2);
        return brickCount * 2;
    }

}
