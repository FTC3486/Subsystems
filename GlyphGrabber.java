package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 3486 on 10/17/2017.
 */

public class GlyphGrabber {
    public Servo LeftServo1;
    public Servo LeftServo2;
    public Servo RightServo1;
    public Servo RightServo2;
    double rightServoPosition1;
    double leftServoPosition1;

    double rightServoPosition2;
    double leftServoPosition2;

    //public boolean isOpen = false;


    /*private enum glyphGrabberEnum {OpenGrabber1, OpenGrabber2, CloseGrabber1, CloseGrabber2}

    glyphGrabberEnum glyphGrabberState = glyphGrabberEnum.CloseGrabber1;

    GlyphGrabber.glyphGrabberEnum clawServoState = GlyphGrabber.glyphGrabberEnum.Close;*/


    public GlyphGrabber(String LeftServo1, String LeftServo2, String RightServo1, String RightServo2, HardwareMap hardwareMap) {
        this.LeftServo1 = hardwareMap.servo.get(LeftServo1);
        this.LeftServo2 = hardwareMap.servo.get(LeftServo2);

        this.RightServo1 = hardwareMap.servo.get(RightServo1);
        this.RightServo2 = hardwareMap.servo.get(RightServo2);

    }
//Initization point for Glyph Grabber paddles
    public void collapsed(){
        LeftServo1.setPosition(0.09);
        LeftServo2.setPosition(0.86);
        RightServo1.setPosition(0.85);
        RightServo2.setPosition(0);
    }
//Close top side of glyph grabber (Initially the top but changes depending on spinner rotation)
    public void closeGrabber1(){
        leftServoPosition1 =0.35;
        LeftServo1.setPosition(leftServoPosition1);
        rightServoPosition1 =0.53;
        RightServo1.setPosition(rightServoPosition1);
    }

    public void adjustCloseGrabber1(){
        leftServoPosition1 =leftServoPosition1 - 0.01;
        LeftServo1.setPosition(leftServoPosition1);
        rightServoPosition1 =rightServoPosition1 +0.01;
        RightServo1.setPosition(rightServoPosition1);
    }
    //Close bottom side of glyph grabber (Initially the bottom but changes depending on spinner rotation)
    public void closeGrabber2(){
        leftServoPosition2 =0.68;
        LeftServo2.setPosition(leftServoPosition2);
        rightServoPosition2 =0.43;
        RightServo2.setPosition(rightServoPosition2);
    }

    public void adjustCloseGrabber2(){
        leftServoPosition2 =leftServoPosition2 - 0.01;
        LeftServo2.setPosition(leftServoPosition2);
        rightServoPosition2 =rightServoPosition2 +0.01;
        RightServo2.setPosition(rightServoPosition2);
    }
    //Open top side of glyph grabber (Initially the top but changes depending on spinner rotation)
    public void openGrabber1(){
        leftServoPosition1 =0.67;
        LeftServo1.setPosition(leftServoPosition1);
        rightServoPosition1 =0.21;
        RightServo1.setPosition(rightServoPosition1);
    }

    public void adjustOpenGrabber1(){
        leftServoPosition1 =leftServoPosition1 + 0.01;
        LeftServo1.setPosition(leftServoPosition1);
        rightServoPosition1 =rightServoPosition1 - 0.01;
        RightServo1.setPosition(rightServoPosition1);
    }
    //Open top side of glyph grabber (Initially the bottom but changes depending on spinner rotation)
    public void openGrabber2(){
        leftServoPosition2 =0.34;
        LeftServo2.setPosition(leftServoPosition2);
        rightServoPosition2 =0.9;
        RightServo2.setPosition(rightServoPosition2);
    }

    public void adjustOpenGrabber2(){
        leftServoPosition2 =leftServoPosition2 + 0.01;
        LeftServo2.setPosition(leftServoPosition2);
        rightServoPosition2 =rightServoPosition2 -0.01;
        RightServo2.setPosition(rightServoPosition2);
    }


    @Override
    public String toString() {


                return "unknown";
        }
    }

