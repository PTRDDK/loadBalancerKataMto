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
        currentLoadPercentage += loadOfVm(vm);
        this.vms.add(vm);
    }

    private double loadOfVm(Vm vm) {
        return (double) vm.getSize() / (double) getCapacity() * MAXIMUM_LOAD;
    }

    public int countVms() {
        return vms.size();
    }

    public boolean canFit(Vm vm) {
        return currentLoadPercentage + loadOfVm(vm) <= MAXIMUM_LOAD;
    }

    public int getCapacity() {
        return capacity;
    }
}
