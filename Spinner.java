package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;


/**
 * Created by John Paul Ashour on 11/13/2016.
 */

public class Spinner {
    public DcMotor Spinner = null;
    public DigitalChannel spinnerTouch;

    private enum spinnerEnum {Position1, Position2, Stop}

    private spinnerEnum ColumnState = spinnerEnum.Stop;


    public Spinner(String Spinner, String Touch, HardwareMap hardwareMap) {
        this.Spinner = hardwareMap.dcMotor.get(Spinner);
        spinnerTouch= hardwareMap.get(DigitalChannel.class, Touch);
        spinnerTouch.setMode(DigitalChannel.Mode.INPUT);
    }

    //Initial Spinner position, detected with Optical Distance Sensor
    public void Position1() {
        if (Spinner.getCurrentPosition() < -5) {
            Spinner.setPower(0.4);

        } else {
            Spinner.setPower(0);
        }
    }

    //Alternate Spinner position, detected with Optical Distance Sensor
    public void Position2() {
        if (Spinner.getCurrentPosition() > -550) {
            Spinner.setPower(-0.4);
        } else {
            Spinner.setPower(0);
        }

    }

    public void Reset() {
        ElapsedTime timer = new ElapsedTime(0);
        while (spinnerTouch.getState() != false && timer.time(TimeUnit.MILLISECONDS) < 1000) {
            Spinner.setPower(0.4);
        }
        stop();
    }

    //Stops spinner motion and holds current position
    public void stop() {
        Spinner.setPower(0);

        Spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public String toString() {
        switch (ColumnState) {
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
