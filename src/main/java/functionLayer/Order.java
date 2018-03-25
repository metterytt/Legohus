package functionLayer;

public class Order {

    private int orderID;
    private final int userID;
    private final int height;
    private final int length;
    private final int width;
    private boolean sent;

    public Order(int userID, int height, int length, int width) {
        this.userID = userID;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
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

    public boolean isSent() {
        return sent;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

}
