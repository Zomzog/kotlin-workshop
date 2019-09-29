package _3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UntouchablePony {

    private final String name;

    private final String type;

    private final List<UntouchablePony> friends = new ArrayList<>();

    public UntouchablePony(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getFirendCount() {
        return friends.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UntouchablePony that = (UntouchablePony) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(friends, that.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, friends);
    }
}
