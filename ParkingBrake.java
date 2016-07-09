package com.FTC3486.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Matthew on 1/16/2016.
 */
public class ParkingBrake {
    private Servo parkingBrakeServo;
    private boolean isParkingBrakeEngaged = false;

    public ParkingBrake(String parkingBrakeServo, HardwareMap hardwareMap) {
        this.parkingBrakeServo = hardwareMap.servo.get(parkingBrakeServo);
        this.release();
    }

    public void release() {
        parkingBrakeServo.setPosition(1.0);
        isParkingBrakeEngaged = false;
    }

    public void brake() {
        parkingBrakeServo.setPosition(0.337);
        isParkingBrakeEngaged = true;
    }

    @Override
    public String toString() {
        String returnStatus;

        if(isParkingBrakeEngaged) {
            returnStatus = "ENGAGED ";
        } else {
            returnStatus = "DISENGAGED ";
        }

        returnStatus += "position{" + parkingBrakeServo.getPosition() + "}";
        return returnStatus;
    }
}
