package com.FTC3486.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Matthew on 1/16/2016.
 */
public class Plow {
    private Servo leftServo;
    private Servo rightServo;
    private boolean isPlowDown = false;

    public Plow(String leftServo, String rightServo, HardwareMap hardwareMap) {
        this.leftServo = hardwareMap.servo.get(leftServo);
        this.rightServo = hardwareMap.servo.get(rightServo);
        this.goDown();
    }

    public void goDown() {
        leftServo.setPosition(0.0);
        rightServo.setPosition(.68);
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
