package edu.iis.mto.serverloadbalancer;

/**
 * Created by Piotrek on 11.06.2017.
 */
public class ServerBuilder {
    int capacity;

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Server build() {
        return new Server();
    }
}
