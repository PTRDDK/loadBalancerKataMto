package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Piotrek on 11.06.2017.
 */
public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
    private final int expectedVmsCount;

    public ServerVmsCountMatcher(int expectedVmsCount) {
        this.expectedVmsCount = expectedVmsCount;
    }

    public void describeTo(Description description) {
        description.appendText("a server with vms count of ").appendValue(expectedVmsCount);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("a server with vms count of ").appendValue(item.countVms());
    }

    protected boolean matchesSafely(Server server) {
        return doublesAreEqual(this.expectedVmsCount, server.countVms());
    }

    private boolean doublesAreEqual(int d1, int d2) {
        return d1 == d2 || Math.abs(d1 - d2) < 0.01d;
    }


    public static ServerVmsCountMatcher hasAVmsCountOf(int expectedVmsCount) {
        return new ServerVmsCountMatcher(expectedVmsCount);
    }
}
