package com.G2T5203.wingit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class RouteListing {
    @EmbeddedId
    private RouteListingPk routeListingPk; // Embedded composite key

    private double basePrice;

    @OneToMany(mappedBy = "outboundRouteListing", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<Booking> outboundBooking;

    @OneToMany(mappedBy = "inboundRouteListing", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<Booking> inboundBooking;

    public RouteListing(RouteListingPk routeListingPk, double basePrice) {
        this.routeListingPk = routeListingPk;
        this.basePrice = basePrice;
    }

    public RouteListing() {
    }

    public RouteListingPk getRouteListingPk() {
        return routeListingPk;
    }

    public void setRouteListingPk(RouteListingPk routeListingPk) {
        this.routeListingPk = routeListingPk;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public List<Booking> getOutboundBooking() {
        return outboundBooking;
    }

    public void setOutboundBooking(List<Booking> outboundBooking) {
        this.outboundBooking = outboundBooking;
    }

    public List<Booking> getInboundBooking() {
        return inboundBooking;
    }

    public void setInboundBooking(List<Booking> inboundBooking) {
        this.inboundBooking = inboundBooking;
    }

    @Override
    public String toString() {
        return "RouteListing{" +
                "routeListingPk=" + routeListingPk +
                ", basePrice=" + basePrice +
                '}';
    }
}
