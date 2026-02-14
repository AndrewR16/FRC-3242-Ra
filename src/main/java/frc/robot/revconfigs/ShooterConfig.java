package frc.robot.revconfigs;

import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class ShooterConfig {
    public static final SparkMaxConfig launcherConfig = new SparkMaxConfig();
    public static final SparkMaxConfig feederConfig = new SparkMaxConfig();

    static {
        launcherConfig
            .inverted(false)
            .idleMode(IdleMode.kCoast);
        
        feederConfig
            .inverted(false)
            .idleMode(IdleMode.kBrake);
    }
}
