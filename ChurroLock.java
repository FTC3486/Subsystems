package com.FTC3486.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Matthew on 1/26/2016.
 */
public class ChurroLock {
    Servo churroLock;

    enum churroLockEnumeration {UNLOCKED, LOCKED}

    churroLockEnumeration churroLockState = churroLockEnumeration.UNLOCKED;

    public ChurroLock(String churroLock, HardwareMap hardwareMap) {
        this.churroLock = hardwareMap.servo.get(churroLock);
        this.unlock();
    }

    public void unlock() {
        churroLock.setPosition(0.0);
        churroLockState = churroLockEnumeration.UNLOCKED;
    }

    public void lock() {
        churroLock.setPosition(0.8);
        churroLockState = churroLockEnumeration.LOCKED;
    }

    @Override
    public String toString() {
        switch (churroLockState) {
            case UNLOCKED:
                return "UNLOCKED";

            case LOCKED:
                return "LOCKED";

            default:
                return "UNKNOWN";
        }
    }
}