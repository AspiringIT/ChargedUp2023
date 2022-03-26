// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  // Left Side Motors
  private final Spark LF = new Spark(DriveConstants.DRIVETRAIN_LEFT_FRONT_SPARK);
  private final Spark LB = new Spark(DriveConstants.DRIVETRAIN_LEFT_BACK_SPARK);
  
  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(LF, LB);

  // Right Side Motors
 private final Spark RF = new Spark(DriveConstants.DRIVETRAIN_RIGHT_FRONT_SPARK);
 private final Spark RB = new Spark(DriveConstants.DRIVETRAIN_RIGHT_BACK_SPARK);


  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(RF, RB);
  
  // Makine Differential Drive Variable
  private DifferentialDrive m_drive;
  
  public DriveSubsystem() {

    // Setting the Right Side Motors as Inverted
    m_rightMotors.setInverted(true);

    // // Drive Base for Left and Right Side Motorss
    m_drive = new DifferentialDrive(m_rightMotors, m_leftMotors);
  }


  // Arcade Drive for Robot Moving at 70% Power and turning at 65% Power
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
