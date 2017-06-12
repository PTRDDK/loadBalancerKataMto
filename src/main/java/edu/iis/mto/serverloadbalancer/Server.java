package edu.iis.mto.serverloadbalancer;


import static edu.iis.mto.serverloadbalancer.ServerLoadBalancer.MAXIMUM_LOAD;

public class Server {

	public double currentLoadPecentage;
	public int capacity;

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public boolean contains(Vm vm) {
		return true;
	}

    public void addVms(Vm vm) {
        currentLoadPecentage = (double)vm.size / (double) capacity * MAXIMUM_LOAD;
    }
}
