package edu.iis.mto.serverloadbalancer;


import static edu.iis.mto.serverloadbalancer.CurrentLoadPercentageMatcher.hasLoadPercentageOf;
import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}


	@Test
	public void balancingAServer_noVms_serverStaysEmpty(){
		Server theServer = a(server().withCapacity(1));
		
		balance(aListOfServersWith(theServer), anEmptyListOfVms());
		
		assertThat(theServer, hasLoadPercentageOf(0.0d));
	}

	@Test
	public void balancingOneServerWithOneSlotCapacity_andOneSlotVm_fillsServerWithTheVm(){
		Server theServer = a(server().withCapacity(1));
		Vm theVm = a(vm().ofSize(1));
		balance(aListOfServersWith(theServer), aVmListWith(theVm));

		assertThat(theServer, hasLoadPercentageOf(100.0d));
		assertThat("server should contain the vm", theServer.contains(theVm));
	}

	private Vm[] aVmListWith(Vm... vms) {
		return vms;
	}

	private VmBuilder vm() {
		return new VmBuilder();
	}

	private void balance(Server[] servers, Vm[] vms) {
		new ServerLoadBalancer().balance(servers, vms);
	}

	private Vm[] anEmptyListOfVms() {
		return new Vm[0];
	}

	private Server[] aListOfServersWith(Server... servers) {
		return servers;
	}

	private Server a(ServerBuilder serverBuilder) {
		return serverBuilder.build();
	}

	private Vm a(VmBuilder vmBuilder){
		return vmBuilder.build();
	}
}
