package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by John Paul Ashour on 11/15/2016.
 */

public class RelicClaw {
    Servo ClawServo1;
    Servo ClawServo2;
    public boolean isOpen = false;

    double claw1position;
    double claw2position;

    private enum clawServoEnum {Open, Close}

    clawServoEnum clawServoState = clawServoEnum.Close;


    public RelicClaw(String clawServo1, String clawServo2, HardwareMap hardwareMap) {
        this.ClawServo1 = hardwareMap.servo.get(clawServo1);
        this.ClawServo2 = hardwareMap.servo.get(clawServo2);
        this.grabRelic();

    }

    public void closeClaw(){
        claw1position = claw1position + 0.01;
        ClawServo1.setPosition(claw1position);
        claw2position = claw2position + 0.01;
        ClawServo2.setPosition(claw2position);
    }

    public void openClaw(){
        claw1position = claw1position - 0.01;
        ClawServo1.setPosition(claw1position);
        claw2position = claw2position - 0.01;
        ClawServo2.setPosition(claw2position);
    }

    public void grabRelic() {
        ClawServo1.setPosition(0);
        ClawServo2.setPosition(0);
        clawServoState = clawServoEnum.Close;
        isOpen = false;
    }

    public void releaseRelic() {
        ClawServo1.setPosition(0.5);
        ClawServo2.setPosition(0.5);
        clawServoState = clawServoEnum.Open;
        isOpen = true;
    }

    @Override
    public String toString() {
        switch (clawServoState) {
            case Open:
                return "Claw Open";

            case Close:
                return "Claw Closed";

            default:
                return "unknown";
        }
    }
}