package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Piotrek on 12.06.2017.
 */
public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
    private int expectedVmsCount;

    public ServerVmsCountMatcher(int expectedVmsCount) {
        this.expectedVmsCount = expectedVmsCount;
    }

    protected boolean matchesSafely(Server server) {
        return expectedVmsCount == server.countVms();
    }

    public void describeTo(Description description) {
        description.appendText("a server with vms number ").appendValue(expectedVmsCount);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("a server with vms number ").appendValue(item.countVms());
    }

    public static ServerVmsCountMatcher hasVmsCountOf(int expectedVmsCount) {
        return new ServerVmsCountMatcher(expectedVmsCount);
    }
}
