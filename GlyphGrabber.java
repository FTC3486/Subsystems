package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 3486 on 10/17/2017.
 */

public class GlyphGrabber {
    private Servo gripAleftservo;
    private Servo gripBleftservo;
    private Servo gripArightservo;
    private Servo gripBrightservo;

    private enum GlyphGrabberEnum {
        OPENED,
        CLOSED,
    }

    private GlyphGrabberEnum gripAstate;
    private GlyphGrabberEnum gripBstate;
    private boolean wasFlipped = false;
    private boolean invertGripControl = false;

    public GlyphGrabber(String gripAleftservo, String gripBleftservo, String gripArightservo, String gripBrightservo, HardwareMap hardwareMap) {
        this.gripAleftservo = hardwareMap.servo.get(gripAleftservo);
        this.gripBleftservo = hardwareMap.servo.get(gripBleftservo);
        this.gripArightservo = hardwareMap.servo.get(gripArightservo);
        this.gripBrightservo = hardwareMap.servo.get(gripBrightservo);

    }

    private void updateInvertGripControl(boolean isFlipped) {
        if (isFlipped != wasFlipped) {
            if (invertGripControl) {
                invertGripControl = !(gripAstate != gripBstate);
            } else {
                invertGripControl = (gripAstate != gripBstate);
            }
            wasFlipped = isFlipped;
        }
    }

    public void gripTop(boolean control, boolean isFlipped) {
        updateInvertGripControl(isFlipped);

        if (isFlipped) {
            if (invertGripControl) {
                if (control) {
                    gripBOpen();
                } else {
                    gripBClose();
                }
            } else {
                if (control) {
                    gripBClose();
                } else {
                    gripBOpen();
                }
            }
        } else {
            if (invertGripControl) {
                if (control) {
                    gripAOpen();
                } else {
                    gripAClose();
                }
            } else {
                if (control) {
                    gripAClose();
                } else {
                    gripAOpen();
                }
            }
        }
    }

    public void gripBottom(boolean control, boolean isFlipped) {
        updateInvertGripControl(isFlipped);

        if (isFlipped) {
            if (invertGripControl) {
                if (control) {
                    gripAOpen();
                } else {
                    gripAClose();
                }
            } else {
                if (control) {
                    gripAClose();
                } else {
                    gripAOpen();
                }
            }
        } else {
            if (invertGripControl) {
                if (control) {
                    gripBOpen();
                } else {
                    gripBClose();
                }
            } else {
                if (control) {
                    gripBClose();
                } else {
                    gripBOpen();
                }
            }
        }
    }

    private void gripAOpen() {
        gripAleftservo.setPosition(0);
        gripArightservo.setPosition(0);
        gripAstate = GlyphGrabberEnum.OPENED;
    }

    private void gripAClose() {
        gripAleftservo.setPosition(1);
        gripArightservo.setPosition(1);
        gripAstate = GlyphGrabberEnum.CLOSED;
    }

    private void gripBOpen() {
        gripBleftservo.setPosition(0);
        gripBrightservo.setPosition(0);
        gripBstate = GlyphGrabberEnum.OPENED;
    }

    private void gripBClose() {
        gripBleftservo.setPosition(1);
        gripBrightservo.setPosition(1);
        gripBstate = GlyphGrabberEnum.CLOSED;
    }

    @Override
    public String toString() {
        String gripAtelemetry;
        String gripBtelemetry;

        switch(gripAstate) {
            case OPENED:
                gripAtelemetry = "opened";
                break;
            case CLOSED:
                gripAtelemetry = "closed";
                break;
            default:
                gripAtelemetry = "unknown";
                break;
        }
        switch(gripBstate) {
            case OPENED:
                gripBtelemetry = "opened";
                break;
            case CLOSED:
                gripBtelemetry = "closed";
                break;
            default:
                gripBtelemetry = "unknown";
                break;
        }

        if (wasFlipped) {
            return String.format("Top Grip: %s\nBottom Grip: %s", gripBtelemetry, gripAtelemetry);
        } else {
            return String.format("Top Grip: %s\nBottom Grip: %s", gripAtelemetry, gripBtelemetry);
        }
    }
}

