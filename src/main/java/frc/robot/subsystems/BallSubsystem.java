// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class BallSubsystem extends SubsystemBase {
  /** Creates a new BallSubsystem. */

  // Declare and Label Shooting Motor (4) and Intake Motor (5)
  
  // Shooting Motor (PWM 4)
  private final Spark m_shooter;

  // Intake Motor (PWM 5)
  private final Spark m_intake;

  // Cylinder Firing Ball (Solenoid (0, 1) )
  private final DoubleSolenoid m_fire;

  public BallSubsystem() {

    /** Initialize Sparks and Pneumatics 
     *  Set them to their Constants
     *  */

    // Shooting Motor (ARM_SHOOT_SPARK)
    m_shooter = new Spark(ArmConstants.ARM_SHOOT_SPARK);

    // Intake Motor (ARM_PICKUP_SPARK)
    m_intake = new Spark(ArmConstants.ARM_PICKUP_SPARK);

    // Firing Cylinder
    m_fire = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 3);
    m_fire.set(Value.kReverse);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Intake Command for Ball Pickup
  public void intakeBall() {
    m_intake.set(0.5);
  }

  // Windup Command for Shooting Motor
  public void windupBall() {
    m_shooter.set(0.7);
  }

  // Stop Command for Shooting and Intake Motors
  public void stopBall() {
    m_intake.set(0);
    m_shooter.set(0);
  }

  // Shoot Command for Firing Cylinder
  public void shootBall() {
    m_fire.set(Value.kForward);
  }

  // Retract Command for Firing Cylinder
  public void retractBall() {
    m_fire.set(Value.kReverse);
  }
}
