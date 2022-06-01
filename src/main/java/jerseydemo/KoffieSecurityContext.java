package jerseydemo;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.SecurityContext;
import java.security.Key;
import java.security.Principal;

public class KoffieSecurityContext implements SecurityContext {

    public static Key key = new SecretKeySpec("WeZittenHierMiddenInDeBepLesTralalaEnNogWatLangerOmMaarMeerBytesTeKrijgenWantEenGoedWachtwoordIsLekkerLang".getBytes(), "HS512");

    private final String username;

    public KoffieSecurityContext(String username){
        this.username = username;
    }

    @Override
    public Principal getUserPrincipal() {
        return new KoffiePrincipal(this.username);
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return "ons eigen ding!";
    }
}
