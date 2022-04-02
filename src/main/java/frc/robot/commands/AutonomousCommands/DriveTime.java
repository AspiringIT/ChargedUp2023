// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveTime extends CommandBase {

  private final DriveSubsystem m_drive;
  private final double m_speed;

  private int counter = 0;
  private int target = 0;


  public DriveTime(double seconds, double speed, DriveSubsystem drive) {
    m_speed = speed;
    m_drive = drive;

    target = (int)(seconds * 50);

    addRequirements(m_drive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_drive.arcadeDrive(m_speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (counter < target) 
    {
      counter++;
    }
    m_drive.arcadeDrive(m_speed, 0);
  
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return counter >= target;
  }
}
