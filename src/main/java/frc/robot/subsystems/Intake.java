/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.List;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;

import edu.wpi.first.vision.VisionRunner.Listener;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake implements Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  List<SpeedController> intakeMotor; 
  public VictorSP intake;
  DoubleSolenoid intakePiston;
  public static DigitalInput beamBreaker;
  
  public Intake(List<SpeedController> intakeMotor)
  {
    intake = new VictorSP(RobotMap.INTAKE);
    intakePiston = new DoubleSolenoid(RobotMap.INTAKE_IN, RobotMap.INTAKE_OUT);
    beamBreaker = new DigitalInput(RobotMap.BEAM_BREAKER);
    this.intakeMotor = intakeMotor;
  }

  public void Running(double power)
  {
    intake.set(ControlMode.PercentOutput, power);
    setMotors(power, intakeMotor);
  }

  private void setMotors(double power, List<SpeedController> intakeMotor2) {
  }

  public void intakeIn()
  {
    intakePiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void intakeOut()
  {
    intakePiston.set(DoubleSolenoid.Value.kForward);
  }

  public boolean beamBreaker(boolean powerCell)
  {
    if(powerCell = true)
    {
      int counter = 0;   //Unless robot starts with preloaded power cells.
      counter++;

      if(counter==5)
      {
        intakeIn();
      }
    }
    return powerCell;
  }

  public void Stop()
  {
    Running(0); 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
