package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

import static edu.iis.mto.serverloadbalancer.ServerLoadBalancer.MAXIMUM_LOAD;

/**
 * Created by Piotrek on 10.06.2017.
 */
public class Server {
    public double currentLoadPercentage;

    List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public int capacity;

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public void addVms(Vm vm) {
        currentLoadPercentage = (double) vm.size / (double) capacity * MAXIMUM_LOAD;
        this.vms.add(vm);
    }

    public int countVms() {
        return vms.size();
    }
}
