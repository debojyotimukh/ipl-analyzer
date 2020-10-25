package com.capgemini.workshop.ipl.dao;

public abstract class IPLPlayer {

    public abstract String getName();

    public abstract Double getAverage();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IPLPlayer))
            return false;
        IPLPlayer other = (IPLPlayer) o;
        return this.getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

}
