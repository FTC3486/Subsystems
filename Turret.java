package com.FTC3486.Subsystems;

import com.FTC3486.FTCRC_Extensions.ExtendedServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Matthew on 1/16/2016.
 */
public class Turret {
    private DcMotor swivel;

    private enum swivelMotorEnum {LEFT, RIGHT, STOP}
    private swivelMotorEnum swivelState = swivelMotorEnum.STOP;

    private DcMotor extender;
    private enum extenderMotorEnum {IN, OUT, STOP}
    private extenderMotorEnum extenderState = extenderMotorEnum.STOP;

    private ExtendedServo dumper;
    private boolean isDumping = false;

    private ExtendedServo dumperSwivel;
    private enum dumperSwivelEnum {LEFT, RIGHT, CENTER}
    private dumperSwivelEnum dumperSwivelState = dumperSwivelEnum.CENTER;

    public Turret(String swivel, String extender, String dumper, String dumperSwivel, HardwareMap hardwareMap) {
        this.swivel = hardwareMap.dcMotor.get(swivel);
        this.extender = hardwareMap.dcMotor.get(extender);
        this.extender.setDirection(DcMotor.Direction.REVERSE);
        this.dumper = new ExtendedServo(hardwareMap.servo.get(dumper));
        this.dumperSwivel = new ExtendedServo(hardwareMap.servo.get(dumperSwivel));

        this.swivel.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        this.swivel.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        this.holdDebris();

        this.dumperSwivelCenter();
    }

    public void swivelRight() {
        swivel.setPower(-1.0);
        swivelState = swivelMotorEnum.RIGHT;
    }

    public void swivelLeft() {
        swivel.setPower(1.0);
        swivelState = swivelMotorEnum.LEFT;
    }

    public void swivelStop() {
        swivel.setPower(0.0);
        swivelState = swivelMotorEnum.STOP;
    }

    public void retract() {
        extender.setPower(-1.0);
        extenderState = extenderMotorEnum.IN;
    }

    public void extend() {
        extender.setPower(1.0);
        extenderState = extenderMotorEnum.OUT;
    }

    public void extenderStop() {
        extender.setPower(0.0);
        extenderState = extenderMotorEnum.STOP;
    }

    public void dumpBlocks(float right_stick_y) {
        dumper.setPosition( (0.525)*right_stick_y + 0.625 );
    }

    /*public void wholeDumpDebris() {
        dumper.setPosition(0.1);
    }*/


    public void halfDumpDebris() {
        dumper.setPosition(0.4);
        isDumping = true;
    }

    public void holdDebris() {
        dumper.setPosition(0.625);
        isDumping = false;
    }

    public void dumperSwivelRight() {
        dumperSwivel.setPosition(0.95);
        dumperSwivelState = dumperSwivelEnum.RIGHT;
    }

    public void dumperSwivelLeft() {
        dumperSwivel.setPosition(0.25);
        dumperSwivelState = dumperSwivelEnum.LEFT;
    }

    public void dumperSwivelCenter() {
        dumperSwivel.setPosition(0.65);
        dumperSwivelState = dumperSwivelEnum.CENTER;
    }

    @Override
    public String toString() {
        String returnString = "Swivel ";
        switch(swivelState) {
            case LEFT:
                returnString += "LEFT";
                break;

            case RIGHT:
                returnString += "RIGHT";
                break;

            case STOP:
                returnString += "STOP";
                break;

            default:
                returnString += "UNKNOWN";
                break;
        }

        returnString += "\nExtender ";
        switch(extenderState) {
            case IN:
                returnString += "IN";
                break;

            case OUT:
                returnString += "OUT";
                break;

            case STOP:
                returnString += "STOP";
                break;

            default:
                returnString += "UNKNOWN";
                break;
        }

        returnString += "\nDumper ";
        if(isDumping) {
            returnString += "DUMPING";
        } else {
            returnString += "HOLDING";
        }

        returnString += "\nDumperSwivel ";
        switch(dumperSwivelState) {
            case RIGHT:
                returnString += "RIGHT";
                break;

            case LEFT:
                returnString += "LEFT";
                break;

            case CENTER:
                returnString += "CENTER";
                break;

            default:
                returnString += "UNKNOWN";
                break;
        }

        return returnString;
    }
}
