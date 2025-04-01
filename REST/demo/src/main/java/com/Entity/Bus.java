package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bus {
@Id
private long id;
private String busNumber;
private String route;
private int capacity;
private String driverName;

public Bus() {
}
public Bus(int id, String busNumber, String route, int capacity, String driverName) {
    this.id = id;
    this.busNumber = busNumber;
    this.route = route;
    this.capacity = capacity;
    this.driverName = driverName;
}
public long getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getBusNumber() {
    return busNumber;
}
public void setBusNumber(String busNumber) {
    this.busNumber = busNumber;
}
public String getRoute() {
    return route;
}
public void setRoute(String route) {
    this.route = route;
}
public int getCapacity() {
    return capacity;
}
public void setCapacity(int capacity) {
    this.capacity = capacity;
}
public String getDriverName() {
    return driverName;
}
public void setDriverName(String driverName) {
    this.driverName = driverName;
}


}
