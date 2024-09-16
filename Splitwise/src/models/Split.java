package models;

public class Split {
    private String userId;
    private double lentAmount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getLentAmount() {
        return lentAmount;
    }

    public void setLentAmount(double lentAmount) {
        this.lentAmount = lentAmount;
    }


    public Split(String userId, double lentAmount) {
        this.userId = userId;
        this.lentAmount = lentAmount;
    }
}
