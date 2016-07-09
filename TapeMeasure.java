package com.FTC3486.Subsystems;

import com.FTC3486.FTCRC_Extensions.ContinuousServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Matthew on 1/16/2016.
 */
public class TapeMeasure {
    ContinuousServo tapeMotor;
    Servo tapeTilt;

    enum tapeMotorEnum {EXTEND, RETRACT, STOP}
    tapeMotorEnum tapeMotorState = tapeMotorEnum.STOP;

    enum tapeTiltEnum {UP, DOWN, STOP}
    tapeTiltEnum tapeTiltState = tapeTiltEnum.STOP;

    public TapeMeasure(String tapeMotor, String tapeTilt, HardwareMap hardwareMap) {
        this.tapeMotor = new ContinuousServo(hardwareMap.servo.get(tapeMotor));
        this.tapeTilt = hardwareMap.servo.get(tapeTilt);
        this.tapeMotor.setPosition(0.5);
        this.tapeTilt.setPosition(0.19);
    }


    public void extendTapeMeasure() {
        tapeMotor.setPower(1.0);
        tapeMotorState = tapeMotorEnum.EXTEND;
    }

    public void retractTapeMeasure() {
        tapeMotor.setPower(-1.0);
        tapeMotorState = tapeMotorEnum.RETRACT;
    }

    public void stopTapeMeasure()
    {
        tapeMotor.setPower(0.0);
        tapeMotorState = tapeMotorEnum.STOP;
    }

    public void tiltDown() {
        tapeTilt.setPosition(tapeTilt.getPosition() + 0.005);
        tapeTiltState = tapeTiltEnum.DOWN;
    }

    public void tiltUp() {
        tapeTilt.setPosition(tapeTilt.getPosition() - 0.005);
        tapeTiltState = tapeTiltEnum.UP;
    }

    public void tiltToScore() { tapeTilt.setPosition(0.165);}

    public void tiltBack() {
        tapeTilt.setPosition(0.04);
    }

    public void stopTilt() {
        tapeTiltState = tapeTiltEnum.STOP;
    }

    @Override
    public String toString() {
        String returnString = "TapeMotor ";

        switch (tapeMotorState) {
            case EXTEND:
                returnString += "EXTEND";
                break;

            case RETRACT:
                returnString += "RETRACT";
                break;

            case STOP:
                returnString += "STOP";
                break;
        }

        returnString += "\nTapeMotor{" + tapeMotor.getPosition() +"}";

        returnString += "\nTapeTilt ";

        switch (tapeTiltState) {
            case UP:
                returnString += "UP";
                break;

            case DOWN:
                returnString += "DOWN";
                break;

            case STOP:
                returnString += "STOP";
                break;
        }

        returnString += "\nTapeTilt{" + tapeTilt.getPosition() +"}";

        return returnString;
    }
}
