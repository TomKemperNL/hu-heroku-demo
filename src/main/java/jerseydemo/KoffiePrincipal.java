package jerseydemo;

import java.security.Principal;

public class KoffiePrincipal implements Principal {
    private String name;

    public KoffiePrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
