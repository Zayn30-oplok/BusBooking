package com.example.demo;

public class BusBook {

    String name, brand, date, time, departure, destination, eat, stat, busNumber;
    int stop;
    double fare;

    public BusBook(String busNum, String busCompany, String busBrand, String origin, String arrival,
                   Integer stops, String date, String time, String estArrival, String status, Double fare) {
        this.busNumber = busNum;
        this.name = busCompany;
        this.brand = busBrand;
        this.departure = origin;
        this.destination = arrival;
        this.stop = stops;
        this.date = date;
        this.time = time;
        this.eat = estArrival;
        this.stat = status;
        this.fare = fare;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

}
