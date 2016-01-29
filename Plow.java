package com.FTC3486.Subsystems;

import com.FTC3486.FTCRC_Extensions.ExtendedServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Matthew on 1/16/2016.
 */
public class Plow {
    private ExtendedServo leftServo;
    private ExtendedServo rightServo;
    private boolean isPlowDown = false;

    public Plow(String leftServo, String rightServo, HardwareMap hardwareMap) {
        this.leftServo = new ExtendedServo(hardwareMap.servo.get(leftServo));
        this.rightServo = new ExtendedServo(hardwareMap.servo.get(rightServo));
        this.goDown();
    }

    public void goDown() {
        leftServo.setPosition(0.18);
        rightServo.setPosition(.5);
        isPlowDown = true;
    }

    public void goUp() {
        leftServo.setPosition(0.57);
        rightServo.setPosition(.113);
        isPlowDown = false;
    }

    @Override
    public String toString() {
        String returnStatus;

        if(isPlowDown) {
            returnStatus = "DOWN ";
        } else {
            returnStatus = "UP ";
        }

        returnStatus += "leftServo{" + leftServo.getPosition() + "} ";
        returnStatus += "rightServo{" + rightServo.getPosition() + "}";
        return returnStatus;
    }
}
