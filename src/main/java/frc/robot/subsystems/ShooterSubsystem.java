package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.MotorCanIds;
import frc.robot.constants.ShooterConstants;
import frc.robot.math.RangeCheck;
import frc.robot.revconfigs.ShooterConfig;

public class ShooterSubsystem extends SubsystemBase {
    // Motors
    private final SparkMax m_launcherMotor = new SparkMax(MotorCanIds.kShooterCanId, null);
    private final SparkMax m_feederMotor = new SparkMax(MotorCanIds.kHopperCanId, null);

    public ShooterSubsystem() {
        m_launcherMotor.configure(ShooterConfig.launcherConfig, ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);
        m_feederMotor.configure(ShooterConfig.feederConfig, ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);
    }

    /**
     * General command to run the launcher motor forward (away from the robot).
     * 
     * @param speed The speed to run as a percentage of the maximum forward speed.
     *              Value should be between 0 and 1.0.
     */
    public Command launcherForwardCommand(double speed) {
        if (RangeCheck.requireInRange(speed, 0, 1) == false) {
            return Commands.print("Improper speed value set for launcherForwardCommand");
        }

        return this.startEnd(
                () -> m_launcherMotor.set(ShooterConstants.kLauncherMaxForwardSpeed * speed),
                () -> m_launcherMotor.set(0));
    }

    /**
     * General command to run the launcher motor in reverse (towards the robot).
     * 
     * @param speed The speed to run as a percentage of the maximum reverse speed.
     *              Value should be between 0 and 1.0.
     */
    public Command launcherReverseCommand(double speed) {
        if (RangeCheck.requireInRange(speed, 0, 1) == false) {
            return Commands.print("Improper speed value set for launcherReverseCommand");
        }

        return this.startEnd(
                () -> m_launcherMotor.set(ShooterConstants.kLauncherMaxReverseSpeed * speed),
                () -> m_launcherMotor.set(0));
    }

    /**
     * General command to run the feeder motor forward (towards the launcher).
     * 
     * @param speed The speed to run as a percentage of the maximum forward speed.
     *              Value should be between 0 and 1.0.
     */
    public Command feederForwardCommand(double speed) {
        if (RangeCheck.requireInRange(speed, 0, 1) == false) {
            return Commands.print("Improper speed value set for feederForwardCommand");
        }

        return this.startEnd(
                () -> m_feederMotor.set(ShooterConstants.kFeederMaxForwardSpeed * speed),
                () -> m_feederMotor.set(0));
    }

    /**
     * General command to run the feeder motor in reverse (towards the hopper).
     * 
     * @param speed The speed to run as a percentage of the maximum reverse speed.
     *              Value should be between 0 and 1.0.
     */
    public Command feederReverseCommand(double speed) {
        if (RangeCheck.requireInRange(speed, 0, 1) == false) {
            return Commands.print("Improper speed value set for feederReverseCommand");
        }

        return this.startEnd(
                () -> m_feederMotor.set(ShooterConstants.kFeederMaxReverseSpeed * speed),
                () -> m_feederMotor.set(0));
    }
}
