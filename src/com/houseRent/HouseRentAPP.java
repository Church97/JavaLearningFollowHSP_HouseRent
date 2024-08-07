package com.houseRent;

import com.houseRent.view.HouseView;

public class HouseRentAPP
{
    //创建HouseView对象，并显示主菜单，是整个程序的入口
    public static void main(String[] args) {
        new HouseView().mainMenu();
        System.out.println("===== 你退出了房屋出租系统 ====");
    }
}
