package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by John Paul Ashour on 11/13/2016.
 */

public class RelicArm {
    public DcMotor Arm = null;


    private enum columnEnum {Extend, Retract, Stop}
    private columnEnum ColumnState = columnEnum.Stop;


    public RelicArm(String Arm, HardwareMap hardwareMap) {
        this.Arm = hardwareMap.dcMotor.get(Arm);
    }
//Runs Glyph Lift up
    public void extend(){
        Arm.setPower(1.0);
    }
//Runs Glyph Lift down
    public void retract(){
        Arm.setPower(-1.0);
    }
//Stops Glyph Lift motion and holds current position
    public void stop(){
        Arm.setPower(0);
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
