package frc.robot.revconfigs;

import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class ShooterConfig {
    public static final SparkFlexConfig launcherConfig = new SparkFlexConfig();
    public static final SparkFlexConfig feederConfig = new SparkFlexConfig();

    static {
        launcherConfig
            .inverted(false)
            .idleMode(IdleMode.kCoast);
        
        feederConfig
            .inverted(false)
            .idleMode(IdleMode.kBrake);
    }
}
