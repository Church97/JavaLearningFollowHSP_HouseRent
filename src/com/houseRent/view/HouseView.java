package com.houseRent.view;

import com.houseRent.domain.House;
import com.houseRent.service.HouseService;
import com.houseRent.utils.Utility;

public class HouseView
{
    private boolean loop = true;
    private char key = ' '; // 用于接受用户选择
    //显示一个主菜单
    private HouseService houseService = new HouseService(4);
    public void mainMenu()
    {
        do
        {
            System.out.println("===========房屋出租系统菜单==========");
            System.out.println("\t\t\t1  新 增 房 源");
            System.out.println("\t\t\t2  查 找 房 屋");
            System.out.println("\t\t\t3  删 除 房 屋 信 息");
            System.out.println("\t\t\t4  修 改 房 屋 信 息");
            System.out.println("\t\t\t5  房 屋 列 表");
            System.out.println("\t\t\t6  退 出 系 统");
            System.out.println("输入你的选择（1-6）");
            key = Utility.readMenuSelection();
            switch (key)
            {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    showHouseList();
                    break;
                case '6':
                    quit();
                    break;

            }
        }while(loop);
    }

    // 修改房屋信息
    public void updateHouse()
    {
        System.out.println("----- 修 改 房 屋 信 息 -----");
        System.out.println("请选择待修改的房屋编号（-1退出）：");
        int updateId = Utility.readInt();
        if(updateId == -1)
            return;

        House updateHouse = houseService.findByID(updateId);
        if (updateHouse == null)
        {
            System.out.println("不存在此ID的房屋信息！无法修改！");
            return;
        }
        System.out.println("姓名 ("+updateHouse.getHouseOwner()+"): ");
        String name = Utility.readString(12,"");//表示如果用户直接回车表示不修改该信息，默认是空串
        if (! "".equals(name))
            updateHouse.setHouseOwner(name);
        System.out.println("电话 ("+updateHouse.getPhone()+"): ");
        String phone = Utility.readString(12,"");//表示如果用户直接回车表示不修改该信息，默认是空串
        if (! "".equals(phone))
            updateHouse.setPhone(phone);
        System.out.println("地址 ("+updateHouse.getAddress()+"): ");
        String address = Utility.readString(16,"");//表示如果用户直接回车表示不修改该信息，默认是空串
        if (! "".equals(address))
            updateHouse.setAddress(address);
        System.out.println("租金 ("+updateHouse.getRentPrice()+"): ");
        int rentPrice = Utility.readInt(-1);
        if (rentPrice != -1)
            updateHouse.setRentPrice(rentPrice);
        System.out.println("状态 ("+updateHouse.getRentState()+"): ");
        String rentState = Utility.readString(3,"");
        if (! "".equals(rentState))
            updateHouse.setRentState(rentState);
        System.out.println("----- 修改成功 -----");
    }


    //查找房屋,接受输入id
    public void findHouse()
    {
        System.out.println("----- 查 找 房 屋 -----");
        System.out.println("请输入你要查找的ID：");
        int findId = Utility.readInt();
        House findHouse = houseService.findByID(findId);
        if (findHouse != null)
            System.out.println(findHouse);
        else
        {
            System.out.println("不存在此ID的房屋信息！");
        }

    }
    public void quit()
    {
        if(Utility.readConfirmSelection() == 'Y')
        {
            System.out.println("---- 你退出了房屋系统 ----");
            loop = false;
        }
    }
    //接收输入，创建house对象，调用add方法
    public void addHouse()
    {
        System.out.println("----- 新 增 房 源 -----");
        System.out.println("房主：");
        String houseName = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(5);
        System.out.println("地址：");
        String address = Utility.readString(16);
        System.out.println("月租：");
        int rentPrice = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);
        House addhouse = new House(0, houseName, phone, address, rentPrice, state);
        if (houseService.add(addhouse))
            System.out.println("添 加 房 屋 成 功 ~ ");
        else
            System.out.println("添 加 房 屋 失 败 ！");

    }

    //显示房屋列表
    public void showHouseList()
    {
        System.out.println("===== 房 屋 列 表 =====");
        System.out.println("编号\t" + '\t' + "房主\t" + '\t' +
                "电话\t" + "\t" +  "地址\t" + '\t' +
                "月租\t" +  "\t" + "状态");
        House[] houselist = houseService.getHouseList();
        for (House house : houselist) {
            if (house == null)
                break;
            System.out.println(house);
        }
        System.out.println("===== 显 示 完 毕 =====");

    }

     // 接收输入的id，删除房屋信息
    public void deleteHouse()
    {
        System.out.println("----- 删 除 房 屋 信 息 -----");
        System.out.println("请输入待删除房屋的编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1)
        {
            System.out.println("取消操作...");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y')
        {
            if( houseService.del(delId) )
                System.out.println(" 删 除 成 功 ~ ");
            else
                System.out.println(" 房屋编号不存在， 删 除 失 败 ！ ");
        }
        else
        {
            System.out.println("取消操作...");
        }





    }


}
