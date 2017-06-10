package edu.iis.mto.serverloadbalancer;

import static edu.iis.mto.serverloadbalancer.ServerLoadBalancer.MAXIMUM_LOAD;

/**
 * Created by Piotrek on 10.06.2017.
 */
public class ServerBuilder implements Builder<Server>{
    private int capacity;
    private double initialLoad;

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Server build() {
        Server server = new Server(capacity);
        if (initialLoad > 0) {
            int initialVmsSize = (int) (initialLoad / (double) capacity * MAXIMUM_LOAD);
            Vm initialVm = VmBuilder.vm().ofSize(initialVmsSize).build();
            server.addVms(initialVm);
        }
        return server;
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }

    public ServerBuilder withCurrentLoadOf(double initialLoad) {
        this.initialLoad = initialLoad;
        return this;
    }
}
