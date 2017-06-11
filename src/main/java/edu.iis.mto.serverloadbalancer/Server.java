package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 11.06.2017.
 */
public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public boolean contains(Vm theVm) {
        return true;
    }

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public void addVms(Vm vm) {
        currentLoadPercentage = (double)vm.size / (double)capacity * MAXIMUM_LOAD;
        this.vms.add(vm);
    }

    public int countVms() {
        return vms.size();
    }
}
