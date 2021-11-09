package edu.upc.dsa.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.InterestPoint;
import io.swagger.models.auth.In;
import org.apache.log4j.Logger;

public class JuegoManagerImpl implements JuegoManager {

    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    private static JuegoManager instance;
    private HashMap<String, User> hashMapUsers = new HashMap<String,User>(); /** Contains all users*/
    private List<InterestPoint> listInterestPoints = new ArrayList<>();  /** Contains all Interest Points of the game.*/

    /**Singleton */
    private JuegoManagerImpl() {
    }
    public static JuegoManager getInstance(){
        if (instance==null) {
            instance = new JuegoManagerImpl();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        logger.info("Add user with id: " + user.getIdUser() + "to the system.");
        this.hashMapUsers.put(user.getIdUser(), user);
        logger.info("User added succesfully.");
    }

    @Override
    public void getUsersOrderedAlphabetical() {
    }

    /** It return the user identified by the input id parameter */
    @Override
    public User getInfoUser(String idUser) {
        logger.info("Information of user with id: " + idUser);
        User u = this.hashMapUsers.get(idUser);
        logger.info("User succesfully found.");
        return u;

    }

    @Override
    public void informUserInterestPoint(String idUser, String idInterestPoint) {
        logger.info("User with id: " + idUser + " passed the interest point with id: " + idInterestPoint);
        User user = this.getInfoUser(idUser);
        InterestPoint interestPoint = this.getInterestPointById(idInterestPoint);
        user.crossInterestPoint(interestPoint);
        interestPoint.addUserPassed(user); //Even if it's redundant, it will make thing easier later.
        logger.info("Notification successfully done.");
    }

    @Override
    public List<InterestPoint> getInterestPointsCrossedByUser (String idUser){
        return this.getInfoUser(idUser).getListCrossedInterestPoints();
    }

    @Override
    public List<User> getUsersInterestPoint(String idInterestPoint) {
        logger.info("Get the list of users that have crossed the interest point with id: " + idInterestPoint);
        InterestPoint interestPoint = new InterestPoint();
        for (InterestPoint i : this.listInterestPoints){
            if (i.getIdInterestPoint() == idInterestPoint){
                interestPoint = i;
            }
        }
        return interestPoint.getListusersPassed();
    }

    @Override
    public List<User> getUsersOrderedInterestPoints() {
        List<User> listUsers = new ArrayList<User>(hashMapUsers.values()); //First put the users in a list */
        Collections.sort(listUsers);
        Collections.reverse(listUsers);
        return listUsers;
    }

    public void addInterestPoint (InterestPoint interestPoint){
        this.listInterestPoints.add(interestPoint);
    }

    public InterestPoint getInterestPointById (String idInterestPoint){
        InterestPoint interestPoint = new InterestPoint();
        for (InterestPoint i : this.listInterestPoints){
            if (i.getIdInterestPoint() == idInterestPoint){
                interestPoint = i;
            }
        }
        return interestPoint;
    }
}
