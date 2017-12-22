package com.example.domain;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

public class Test implements Serializable{


    @XmlElement(name = "protocollo")
    private List<Shipment> shipments;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }
    @Override
    public String toString() {
        return "Test{" +
                "shipments=" + shipments +
                '}';
    }
}
