package com.cgi.device.fan.devices;

import java.util.Formatter;

public class CeilingFan {
    private FanSpeed fanSpeed;

    private int currentSpeed;
    private Direction currentDirection = Direction.CLOCKWISE;

    /**
     * Note1:
     * We all know that any ceiling fan has a pull which reverses the direction, so it is not needed to do any further design.
     *
     * Note2:
     * Client requires 3 speeds, but it could be more(this is just for extension)
     *
     * Note3:
     * Basic validation is needed(Exception is thrown here for simplicity, we can define "InvalidFanException" if needed)
     */
    public static CeilingFan newCeilingFan(FanSpeed fanSpeed) throws Exception{
        if(fanSpeed == null) {
            throw new Exception("Please provide the fan speed");
        }
        return new CeilingFan(fanSpeed);
    }
    
    public static CeilingFan newCeilingFan() {
        return new CeilingFan(FanSpeed.SPEED_3);
    }

    private CeilingFan(FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public void changeSpeed() {
        //In case user pulls two cords at the same time
        synchronized (this) {
            if(this.currentSpeed == this.fanSpeed.getSpeed()) {
                this.currentSpeed = 0;
            } else {
                this.currentSpeed ++;
            }
        }
    }

    public void changeDirection() {
        //In case user pulls two cords at the same time
        synchronized (this) {
            //It just switches between CLOCKWISE and COUNTERCLOCKWISE
            //Another note here, if changing direction allowed when the fan is off?
            this.currentDirection = (currentDirection == Direction.CLOCKWISE ? Direction.COUNTERCLOCKWISE : Direction.CLOCKWISE);
        }
    }

    public String getStatus(){
        if(currentSpeed == 0) {
            return "The fan is off";
        } else {
            return new Formatter().format("The fan is running at speed: %s, direction: %s", this.currentSpeed, this.currentDirection).toString();
        }
    }
}
