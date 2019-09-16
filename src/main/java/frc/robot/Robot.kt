package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

import frc.robot.subsystems.*

class Robot: TimedRobot() {

  companion object { }

  var m_autonomousCommand: Command? = null
  var m_chooser: SendableChooser<Command> = SendableChooser()

  override fun robotInit() {
    m_chooser.setDefaultOption("Default Auto", null)
    // m_chooser.addOption("My Auto", MyAutoCommand())
    SmartDashboard.putData("Auto mode", m_chooser)
  }

  override fun robotPeriodic() {}

  override fun disabledInit() {}

  override fun disabledPeriodic () {
    Scheduler.getInstance().run()
  }

  override fun autonomousInit() {
    /*
     * val autoSelected: String = SmartDashboard.getString("Auto Selector", "Default")
     * m_autonomousCommand = when (autoSelected) {
     *   "My Auto" -> MyAutoCommand()
     *   "Default Auto" -> ExampleCommand()
     *   else -> ExampleCommand()
     * }
     */

    m_chooser.selected?.start()
  }

  override fun autonomousPeriodic() {
    Scheduler.getInstance().run()
  }

  override fun teleopInit() {
    m_autonomousCommand?.cancel()
  }

  override fun teleopPeriodic() {
    Scheduler.getInstance().run()
  }

  override fun testPeriodic() {}
}
