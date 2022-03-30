// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmControls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class RaiseArm extends CommandBase {
  
  // Declare ArmSubsystem as raiser
  ArmSubsystem raiser;
  
  public RaiseArm(ArmSubsystem subsystem) {
    
    // Establish raiser as name of ArmSubsystem
    raiser = subsystem;

    // addRequirements makes the ArmSubsystem a requirement to use
    addRequirements(raiser);
  }




  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Command the Angle Motor to Rise by referencing raiseArm()
    raiser.raiseArm();  
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
