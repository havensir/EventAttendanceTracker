package com.joinup.model;

// TODO: add fields for id, name, date, etc.
public class Event {
    public String id;
    public String name;
    public String dateTime;
    public String location;
    public Integer capacity;

    public Event(String id, String name, String dateTime, String location, Integer capacity){
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.capacity = capacity;
    }

    public String getId() {return id; }
    public String getName() {return name; }
    public String getDateTime() {return dateTime; }
    public String getLocation() {return location; }
    public Integer getCapacity() {return capacity; }
}