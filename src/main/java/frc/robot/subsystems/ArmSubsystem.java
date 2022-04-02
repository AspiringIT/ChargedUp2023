// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */

  // Declare and Label Angle Motor (6)
  // Set True/False values for Arm Going Up and Down

  // Angle Motor (PWM 6)
  private final Spark m_angle;

  // Arm Going Up (True)
  public boolean armUp = true;

  // Arm Going Down (False)
  public boolean armDown = false;


  public ArmSubsystem() {

    /** Initialize Spark and Boolean Values
     *  Set Spark to Constant and Booleans to True/False
     */

    // Angle Motor (ARM_ANGLE_SPARK)
    m_angle = new Spark(ArmConstants.ARM_ANGLE_SPARK);

    armUp = true;
    armDown = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Raise Command for Angle Motor (-)
  public void raiseArm() {
    m_angle.set(-0.1);
  }

  // Lower Command for Angle Motor (+)
  public void lowerArm() {
    m_angle.set(0.4);
  }

  // Stop Command for Angle Motor (0)
  public void stopArm() {
    m_angle.set(0);
  }
}
