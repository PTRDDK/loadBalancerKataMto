package edu.iis.mto.serverloadbalancer;

/**
 * Created by Piotrek on 10.06.2017.
 */
public class ServerLoadBalancer {

    public static final double MAXIMUM_LOAD = 100.0d;

    public void balance(Server[] servers, Vm[] vms) {

        for (Vm vm : vms){
            Server lessLoadedServer = null;
            for(Server server : servers){
                if (lessLoadedServer == null || server.currentLoadPercentage < lessLoadedServer.currentLoadPercentage){
                    lessLoadedServer = server;
                }
            }
            lessLoadedServer.addVms(vm);
        }
    }
}
