package edu.iis.mto.serverloadbalancer;

import static edu.iis.mto.serverloadbalancer.ServerLoadBalancer.MAXIMUM_LOAD;

/**
 * Created by Piotrek on 10.06.2017.
 */
public class Server {
    public double currentLoadPercentage;

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public int capacity;

    public boolean contains(Vm theVm) {
        return true;
    }

    public void addVms(Vm vm) {
        currentLoadPercentage = (double) vm.size / (double) capacity * MAXIMUM_LOAD;
    }
}
