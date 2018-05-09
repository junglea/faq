package com.junglea.faq.authorization;

import com.junglea.faq.authentication.FakeSession;
import com.junglea.faq.model.ApiUser;

/**
 * A way to allow or not access depends of a sessionId
 * Define some requestTypes
 *
 *
*/

public class FaqAuthority {

    public enum RequestType {
        SEARCH,
        LISTALL,
        CREATE,
        UPDATE
    }

    /**
     * Allow or not access to request
     *
     *
     * @param reqType
     * @param sessionId
     * @return true is user is authorized
     */
    public static boolean isAuthorizated(RequestType reqType, String sessionId){
        if (reqType != null) {
            // Retrieve user role with sessionID
            ApiUser user = FakeSession.getInstance().getUser(sessionId);
            if (user != null ) {
                switch (reqType) {
                    case SEARCH:
                        // Search if allow for all
                        return true;
                    // other actions in faq are admin only
                    case CREATE:
                    case UPDATE:
                    case LISTALL:
                        return ApiUser.UserRole.ADMIN.equals(user.getRole());
                    default:
                        // log.error("reqType [{}] is unknown", reqType);
                }
            }
        } else {
            // log.error("No reqType [{}] or userType [{}] specified", reqType, userType);
        }
        // Throw an exception to display specific page to user
        return false;
    }
}
