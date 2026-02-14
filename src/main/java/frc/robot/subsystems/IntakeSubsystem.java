package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IntakeConstants;
import frc.robot.constants.MotorCanIds;
import frc.robot.math.RangeCheck;
import frc.robot.revconfigs.IntakeConfig;

public class IntakeSubsystem extends SubsystemBase {
    private final SparkFlex m_intakeMotor = new SparkFlex(MotorCanIds.kIntakeCanId, null);

    public IntakeSubsystem() {
        m_intakeMotor.configure(IntakeConfig.intakeConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    /**
     * General command to run the intake motor forward (into the robot).
     * 
     * @param speed The speed to run as a percentage of the maximum forward speed.
     *              Value should be between 0 and 1.0.
     */
    public Command intakeForwardCommand(double speed) {
        if (RangeCheck.requireInRange(speed, 0, 1) == false) {
            return Commands.print("Improper speed value set for intakeForwardCommand");
        }

        return this.startEnd(
                () -> m_intakeMotor.set(IntakeConstants.kIntakeMaxForwardSpeed * speed),
                () -> m_intakeMotor.set(0));
    }

    /**
     * General command to run the intake motor reverse (away from the robot).
     * 
     * @param speed The speed to run as a percentage of the maximum reverse speed.
     *              Value should be between 0 and 1.0.
     */
    public Command intakeReverseCommand(double speed) {
        if (RangeCheck.requireInRange(speed, 0, 1) == false) {
            return Commands.print("Improper speed value set for intakeReverseCommand");
        }

        return this.startEnd(
                () -> m_intakeMotor.set(IntakeConstants.kIntakeMaxReverseSpeed * speed),
                () -> m_intakeMotor.set(0));
    }
}
