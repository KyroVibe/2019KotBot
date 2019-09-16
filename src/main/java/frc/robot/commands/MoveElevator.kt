package frc.robot.commands

import edu.wpi.first.wpilibj.command.Command

import frc.robot.Robot
import frc.robot.subsystems.Elevator

class MoveElevator(speed: Double): Command() {

  val speed: Double

  init {
    this.speed = speed
    requires(Elevator)
  }

  override fun execute() {
    Elevator.SetSpeed(speed)
  }

  override fun isFinished(): Boolean {
    return false
  }

  override fun interrupted() {
    end()
  }

  override fun end() {
    Elevator.SetVelocity(0.0);
  }
}
