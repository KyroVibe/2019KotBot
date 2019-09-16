package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.Drivetrain
import frc.robot.OI
import frc.robot.RobotMap

class ArcadeMixer : Command() {

  init {
    requires(Drivetrain)
  }

  override fun execute() {
    val forward: Double = -OI.GetAxis(RobotMap.leftYAxis)
    val turn: Double = OI.GetAxis(RobotMap.rightXAxis)

    Drivetrain.ArcadeMixer(forward, turn)
  }

  override fun isFinished() : Boolean {
    return false
  }

  override fun interrupted() {
    end()
  }

  override fun end() {
    Drivetrain.SetSpeed(0.0, 0.0)
  }

}