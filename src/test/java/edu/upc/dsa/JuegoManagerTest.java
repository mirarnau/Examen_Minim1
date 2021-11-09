package edu.upc.dsa;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.InterestPoint;
import edu.upc.dsa.util.JuegoManager;
import edu.upc.dsa.util.JuegoManagerImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JuegoManagerTest {
    User user0;
    User user1;
    User user2;
    JuegoManager manager;

    @After
    public void tearDown() {    }

    @Before
    public void setUp(){
        manager = JuegoManagerImpl.getInstance();

        //Definition of the initial users.
        user0 = new User("Arnau");
        user1 = new User("Bianca");
        user2 = new User("Jordi");

        manager.addUser(user0);
        manager.addUser(user1);
        manager.addUser(user2);

        //Definition of the interest points.
        InterestPoint interestPoint0 = new InterestPoint("Bridge");
        InterestPoint interestPoint1 = new InterestPoint("Door");
        InterestPoint interestPoint2 = new InterestPoint("Hall");
        InterestPoint interestPoint3 = new InterestPoint("Bathroom");
        InterestPoint interestPoint4 = new InterestPoint("Restaurant");

        manager.addInterestPoint(interestPoint0);
        manager.addInterestPoint(interestPoint1);
        manager.addInterestPoint(interestPoint2);
        manager.addInterestPoint(interestPoint3);
        manager.addInterestPoint(interestPoint4);

        //Users cross different interest points */
        manager.informUserInterestPoint(user0.getIdUser(), interestPoint0.getIdInterestPoint());
        manager.informUserInterestPoint(user0.getIdUser(), interestPoint1.getIdInterestPoint());
        manager.informUserInterestPoint(user0.getIdUser(), interestPoint2.getIdInterestPoint());

        manager.informUserInterestPoint(user1.getIdUser(), interestPoint3.getIdInterestPoint());
        manager.informUserInterestPoint(user1.getIdUser(), interestPoint2.getIdInterestPoint());

        manager.informUserInterestPoint(user2.getIdUser(), interestPoint4.getIdInterestPoint());
    }

    @Test
    public void testGetInfoUser(){
        Assert.assertEquals("Arnau", manager.getInfoUser("Arnau").getIdUser());
    }

    @Test
    public void testGetInterestPointsCrossedByUser(){
        Assert.assertEquals(3, manager.getInterestPointsCrossedByUser(user0.getIdUser()).size());
    }

    @Test
    public void testGetUsersInterestPoint(){
        Assert.assertEquals(2, manager.getUsersInterestPoint("Hall").size());
    }

    @Test
    public void testGetUsersOrderedInterestPoints(){
        Assert.assertEquals("Arnau", manager.getUsersOrderedInterestPoints().get(0).getIdUser());
    }

}
