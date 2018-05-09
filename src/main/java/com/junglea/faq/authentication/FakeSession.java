package com.junglea.faq.authentication;

import com.junglea.faq.model.ApiUser;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is fake Session class used to store user informations with a SessionID
 *
*/

public class FakeSession {

    private static FakeSession fakeSession;

    private Map<String, ApiUser> users = new HashMap<>();

    public static synchronized FakeSession getInstance() {
        if (fakeSession == null) {
            fakeSession = new FakeSession();
        }
        return fakeSession;
    }

    public void setUserSession(String sessionId, ApiUser user){
        users.put(sessionId, user);
    }

    public ApiUser getUser(String sessionId) {
        return users.get(sessionId);
    }
}
