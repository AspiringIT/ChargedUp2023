// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  // Left Side Motors
private final MotorControllerGroup m_leftMotors =
  new MotorControllerGroup(
    new CANSparkMax(10, MotorType.kBrushed),
    new CANSparkMax(11, MotorType.kBrushed));

 
  // Right Side Motors
  private final MotorControllerGroup m_rightMotors =
  new MotorControllerGroup(
    new CANSparkMax(12, MotorType.kBrushed),
    new CANSparkMax(13, MotorType.kBrushed));
  
  // Makine Differential Drive Variable
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  
  public DriveSubsystem() {

    // Setting the Right Side Motors as Inverted
    m_rightMotors.setInverted(true);

    m_leftMotors.setInverted(false);


  }


  // Arcade Drive for Robot Moving at 100% Power
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);

  }
}
