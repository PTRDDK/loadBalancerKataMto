package edu.iis.mto.serverloadbalancer;

/**
 * Created by Piotrek on 12.06.2017.
 */
public class VmBuilder {
    private int size;

    public VmBuilder ofSize(int size) {
        this.size = size;
        return this;
    }

    public Vm build() {
        return new Vm();
    }
}
