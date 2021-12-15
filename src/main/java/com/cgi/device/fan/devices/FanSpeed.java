package com.cgi.device.fan.devices;

public enum FanSpeed {
    //there could be only a few choices(i.e. speed == 100 doesn't make sense)
    SPEED_3(3), SPEED_4(4), SPEED_5(5);

    private final int speed;

    private FanSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
