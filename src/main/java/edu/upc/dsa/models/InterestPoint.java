package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class InterestPoint {
    private String idInterestPoint; //Name of the interest point (puerta, casilla X, puente, etc.)
    private List<User> listUsersPassed = new ArrayList<User>();

    public void setIdInterestPoint(String idInterestPoint) {
        this.idInterestPoint = idInterestPoint;
    }

    public String getIdInterestPoint() {
        return idInterestPoint;
    }

    public List<User> getListusersPassed() {
        return listUsersPassed;
    }

    public InterestPoint(String idInterestPoint){
        this.idInterestPoint = idInterestPoint;
    }
    public InterestPoint (){};

    public void addUserPassed (User user){
        this.listUsersPassed.add(user);
    }


}
