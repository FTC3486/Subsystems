package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by John Paul Ashour on 11/13/2016.
 */

public class GlyphLift {
    public DcMotor Lift = null;
    public DigitalChannel liftTouch;



    private enum columnEnum {Extend, Retract, Stop}
    private columnEnum ColumnState = columnEnum.Stop;


    public GlyphLift(String Lift, String Touch, HardwareMap hardwareMap) {
        this.Lift = hardwareMap.dcMotor.get(Lift);

        liftTouch= hardwareMap.get(DigitalChannel.class, Touch);
        liftTouch.setMode(DigitalChannel.Mode.INPUT);
    }
//Runs Glyph Lift up
    public void lift(){
        Lift.setPower(1.0);
    }
//Runs Glyph Lift down
    public void retract(){
        if(liftTouch.getState() == true){
        Lift.setPower(-1.0);
        }
    }
//Stops Glyph Lift motion and holds current position
    public void stop(){
        Lift.setPower(0);
    }

    @Override
    public String toString() {
        switch (ColumnState){
            case Extend:
                return "Extending";

            case Retract:
                return "Retracting";

            case Stop:
                return "Stopped";

            default:
                return "Unknown";

        }


    }


}
