package edu.iis.mto.serverloadbalancer;

public class ServerBuilder implements Builder<Server> {

	public static final double MAXIMUM_LOAD = 100.0d;
	private int capacity;
	private double initialLoad;

	public ServerBuilder withCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Server build() {
		Server server = new Server(capacity);
		addInitialLoad(server);
		return server;
	}

	private void addInitialLoad(Server server) {
		if (initialLoad > 0) {
			int initialVmLoad = (int) (initialLoad / (double) capacity * MAXIMUM_LOAD);
			Vm initialVm = VmBuilder.vm().ofSize(initialVmLoad).build();
			server.addVm(initialVm);
		}
	}

	public static ServerBuilder server() {
		return new ServerBuilder();
	}

	public ServerBuilder withCurrentLoadOf(double initialLoad) {
		this.initialLoad = initialLoad;
		return this;
	}
}
