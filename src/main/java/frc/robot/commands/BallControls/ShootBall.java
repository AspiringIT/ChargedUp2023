// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.BallControls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.BallSubsystem;

public class ShootBall extends CommandBase {
  
  // Declare BallSubsystem as shooter
  BallSubsystem shooter;

  private XboxController m_copilotController;
  
  public ShootBall(BallSubsystem subsystem) {
    
    // Establish shooter as name of Ballsubsystem
    shooter = subsystem;

    // addRequirements makes the BallSubsystem a requirement to use
    addRequirements(shooter);

    m_copilotController = new XboxController(ControllerConstants.CopilotControllerPort);


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_copilotController.getYButtonPressed()) {
    // Start Windup Motor (4)
    shooter.windupBall();

    // Wait for 2 second
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {}

    // Command Firing Cylinder to Push Ball forward by referencing shootBall()
    shooter.shootBall();

    // Wait for 1/2 second
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {}

    // Stop Windup Motor (4)
    shooter.stopBall();
    shooter.retractBall();
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
