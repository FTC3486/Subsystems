package com.FTC3486.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Matthew on 1/26/2016.
 */
public class ClimberDump {
    Servo climberDump;
    public boolean hasDumped = false;

    enum climberDumperEnumeration {HOLDING, STAYINGVERTICAL, DUMPING}

    climberDumperEnumeration climberDumperState = climberDumperEnumeration.HOLDING;

    public ClimberDump(String climberDump, HardwareMap hardwareMap) {
        this.climberDump = hardwareMap.servo.get(climberDump);
        this.holdClimbers();
    }

    public void holdClimbers() {
        climberDump.setPosition(0.7);
        climberDumperState = climberDumperEnumeration.HOLDING;
    }

    public void stayVertical() {
        climberDump.setPosition(0.655);
        climberDumperState = climberDumperEnumeration.STAYINGVERTICAL;
    }

    public void dumpClimbers() {
        climberDump.setPosition(0.6);
        climberDumperState = climberDumperEnumeration.DUMPING;
    }

    @Override
    public String toString() {
        switch (climberDumperState) {
            case HOLDING:
                return "HOLDING";

            case STAYINGVERTICAL:
                return "STAYING VERTICAL";

            case DUMPING:
                return "DUMPING";

            default:
                return "UNKNOWN";
        }
    }
}
