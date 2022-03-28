// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  
  // Right Cylinder
  private final DoubleSolenoid m_climb;

  
  public ClimbSubsystem() {

  // Two Cylinders For Climb (Ports 1, 2)
  m_climb = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

  // Solenoid set to the Inside
  m_climb.set(Value.kReverse);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Climbup Command for Climbing Arms
  public void climbUp() {
  m_climb.set(Value.kOff);
  m_climb.set(Value.kForward);
  }

  // Climbdown Command for Climbing Arms
  public void climbDown() {
    m_climb.set(Value.kOff);
    m_climb.set(Value.kReverse);
  }

}
