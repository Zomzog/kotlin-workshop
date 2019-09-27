package _1;

import _99.Workshop;

import java.util.Objects;
import java.util.stream.Stream;

public class Workshop_old {
    private final String name;
    private Long attendeesCount;

    public Workshop_old(String name, Long attendeesCount) {
        this.name = name;
        this.attendeesCount = attendeesCount;
    }

    public String getName() {
        return name;
    }

    public Long getAttendeesCount() {
        return attendeesCount;
    }

    public void setAttendeesCount(Long attendeesCount) {
        this.attendeesCount = attendeesCount;
    }

    public String toString() {
        return "Workshop(name=" + this.name + ", attendeesCount=" + this.attendeesCount + ")";
    }

    public int hashCode() {
        int nameHash = (name != null ? name.hashCode() : 0) * 31;
        return nameHash + (int)(attendeesCount ^ attendeesCount >>> 32);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workshop workshop = (Workshop) o;
        return Objects.equals(name, workshop.name) &&
                Objects.equals(attendeesCount, workshop.attendeesCount);
    }
}
