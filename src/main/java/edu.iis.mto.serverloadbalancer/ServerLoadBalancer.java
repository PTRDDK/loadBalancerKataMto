package edu.iis.mto.serverloadbalancer;

/**
 * Created by Piotrek on 11.06.2017.
 */
public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {
        if (vms.length > 0){
            servers[0].addVms(vms[0]);
        }
    }
}
