package com.cgi.device.fan;

import com.cgi.device.fan.devices.CeilingFan;
import com.cgi.device.fan.devices.FanSpeed;

public class Portal {
    public static void main(String[] args) throws Exception{
        CeilingFan fan = CeilingFan.newCeilingFan(FanSpeed.SPEED_3);
        System.out.println(fan.getStatus());
        fan.changeSpeed();
        System.out.println(fan.getStatus());
        fan.changeDirection();
        System.out.println(fan.getStatus());

        fan.changeSpeed();
        System.out.println(fan.getStatus());
        fan.changeSpeed();
        System.out.println(fan.getStatus());
        fan.changeSpeed();
        System.out.println(fan.getStatus());
    }
}
