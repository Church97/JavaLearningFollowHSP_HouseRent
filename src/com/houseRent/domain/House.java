package com.houseRent.domain;

/**
 * House的对象表示一个房屋信息
 */
public class House
{
    private int id;
    private String houseOwner;
    private String phone;
    private String address;
    private int rentPrice;
    private String rentState;
    // 构造器和相应的方法


    public House(int id, String houseOwner, String phone, String address, int rentPrice, String rentState)
    {
        this.id = id;
        this.houseOwner = houseOwner;
        this.phone = phone;
        this.address = address;
        this.rentPrice = rentPrice;
        this.rentState = rentState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        this.houseOwner = houseOwner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentState() {
        return rentState;
    }

    public void setRentState(String rentState) {
        this.rentState = rentState;
    }

    @Override
    public String toString() {
        return id + "\t\t" + houseOwner + '\t' +
                phone + '\t' +  address + '\t' +
                rentPrice +  "\t" + rentState;
    }
}

