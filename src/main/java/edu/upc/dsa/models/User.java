package edu.upc.dsa.models;


import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class User implements Comparable <User> {
    private String idUser; //Which is the name.
    private List <InterestPoint> listCrossedInterestPoints = new ArrayList<InterestPoint>();

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public List<InterestPoint> getListCrossedInterestPoints() {
        return listCrossedInterestPoints;
    }

    public void crossInterestPoint (InterestPoint interestPoint){
        this.listCrossedInterestPoints.add(interestPoint);
    }

    /** To compare by list of crossed interest points */
    public int compareTo (User u){
        return Integer.compare(this.listCrossedInterestPoints.size(), u.getListCrossedInterestPoints().size());
    }

    /**
    public int compareTo(User u) {
        return u.getIdUser().compareTo(this.idUser);
    }
     */

    public User (String idUser){
        this.idUser = idUser;
    }
    public User(){};



}
