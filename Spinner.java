package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;


/**
 * Created by John Paul Ashour on 11/13/2016.
 */

public class Spinner {
    public DcMotor Spinner = null;
    public ColorSensor Ods;



    private enum spinnerEnum {Position1, Position2, Stop}

    private spinnerEnum ColumnState = spinnerEnum.Stop;


    public Spinner(String Spinner, String Ods, HardwareMap hardwareMap) {
        this.Spinner = hardwareMap.dcMotor.get(Spinner);
        this.Ods = hardwareMap.colorSensor.get(Ods);
    }
//Initial Spinner position, detected with Optical Distance Sensor
    public void Position1() {
        if (Spinner.getCurrentPosition()>30) {
            Spinner.setPower(-0.4);

        } else {
            Spinner.setPower(0);
    }
    }
    //Alternate Spinner position, detected with Optical Distance Sensor
    public void Position2() {
                if (Spinner.getCurrentPosition()<560) {
            Spinner.setPower(0.4);
        }else{
            Spinner.setPower(0);
        }

    }

    public void Reset(){
        stop();
        while (Spinner.getCurrentPosition()>-580){
            Spinner.setPower(-0.4);
        }
        stop();
    }

//Stops spinner motion and holds current position
    public void stop(){
        Spinner.setPower(0);

        Spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public String toString() {
        switch (ColumnState){
            case Position1:
                return "Position 1";

            case Position2:
                return "Position 2";

            case Stop:
                return "Stopped";

            default:
                return "Unknown";

        }


    }


}
