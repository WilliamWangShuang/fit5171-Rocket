package rockets.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notNull;

public class Launch extends Entity {
    public enum LaunchOutcome {
        FAILED, SUCCESSFUL
    }

    private Date launchDate;

    private Rocket launchVehicle;

    private LaunchServiceProvider launchServiceProvider;

    private Set<String> payload;

    private String launchSite;

    private String orbit;

    private String function;

    private LaunchOutcome launchOutcome;

    public Launch(Date launchDate, Rocket launchVehicle, LaunchServiceProvider launchServiceProvider, String launchSite, String orbit) {
        notNull(launchDate);
        notNull(launchVehicle);
        notNull(launchServiceProvider);
        notNull(launchSite);
        notNull(orbit);

        this.launchDate = launchDate;
        this.launchVehicle = launchVehicle;
        this.launchServiceProvider = launchServiceProvider;
        this.launchSite = launchSite;
        this.orbit = orbit;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public Rocket getLaunchVehicle() {
        return launchVehicle;
    }

    public LaunchServiceProvider getLaunchServiceProvider() {
        return launchServiceProvider;
    }

    public Set<String> getPayload() {
        return payload;
    }

    public String getLaunchSite() {
        return launchSite;
    }

    public String getOrbit() {
        return orbit;
    }

    public String getFunction() {
        return function;
    }

    public LaunchOutcome getLaunchOutcome() {
        return launchOutcome;
    }

    public void setPayload(Set<String> payload) {
        this.payload = payload;
    }

    public void setLaunchSite(String launchSite) {
        this.launchSite = launchSite;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setLaunchOutcome(LaunchOutcome launchOutcome) {
        this.launchOutcome = launchOutcome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Launch launch = (Launch) o;
        return Objects.equals(launchDate, launch.launchDate) &&
                Objects.equals(launchVehicle, launch.launchVehicle) &&
                Objects.equals(launchServiceProvider, launch.launchServiceProvider) &&
                Objects.equals(orbit, launch.orbit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(launchDate, launchVehicle, launchServiceProvider, orbit);
    }
}
