package edu.upc.dsa.util;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.InterestPoint;
import io.swagger.models.auth.In;
import org.apache.log4j.Logger;

import java.util.List;

public interface JuegoManager {
    void addUser(User user);
    void getUsersOrderedAlphabetical();
    User getInfoUser(String idUser);
    void informUserInterestPoint(String idUser, String idInterestPoint); /** Manages the operations carried out when a user crosses an interest point.*/
    List<InterestPoint> getInterestPointsCrossedByUser (String idUser); /** Consult interest points that a user has crossed.*/
    List<User> getUsersInterestPoint(String idInterestPoint); /** Get the users that have crossed that interest point.*/
    List<User> getUsersOrderedInterestPoints();

    void addInterestPoint (InterestPoint interestPoint);
    InterestPoint getInterestPointById (String idInterestPoint);

}
