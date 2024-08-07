package com.houseRent.service;

import com.houseRent.domain.House;

public class HouseService
{
    private House [] houseList;
    private int houseNum = 3;
    private int idCounter = 3;

    public HouseService(int size) {
        houseList = new House[size];
        houseList[0] = new House(1,"qiuqi","11223","广州市",5000,"未出租");
        houseList[1] = new House(2,"mike","22123","天河区",2200,"未出租");
        houseList[2] = new House(3,"alice","54123","黄埔区",3200,"未出租");
    }

    public House[] getHouseList()
    {
        return houseList;
    }
    // add方法，添加新房屋对象，返回布尔值
    public boolean add(House addhouse)
    {
        //判断是否还可以继续添加，暂时不考虑其他问题
        if (houseNum == houseList.length)
        {
            System.out.println("数组已满，不能再添加了");
            return false;
        }
            addhouse.setId(++idCounter);
            houseList[houseNum++] = addhouse;
            return true;

    }

    public House findByID(int findId)
    {
        for (int i = 0; i < houseNum; i++)
        {
            if (findId == houseList[i].getId())
            {
                return houseList[i];
            }
        }
        return null;
    }




    //删除一个房屋信息，返回布尔值
    public boolean del(int delId)
    {
        int index = -1;
        for (int i = 0; i < houseNum; i++)
        {
            if (houseList[i].getId() == delId)
                index = i;
        }

        if (index == -1)
        {
            return false;
        }
        for (int j = index; j < houseNum -1; j++)
        {
            houseList[j] = houseList[j+1];
        }
        houseList[--houseNum] = null;
        return true;
    }

}
