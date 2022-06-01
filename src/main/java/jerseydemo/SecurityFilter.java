package jerseydemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authheader = requestContext.getHeaderString("Authorization");

        if (authheader != null) {

            authheader = authheader.replace("Bearer ", "");
            try{
                Jws<Claims> claimswut = Jwts.parser().setSigningKey(KoffieSecurityContext.key).parseClaimsJws(authheader);
                String subject = claimswut.getBody().getSubject();
                requestContext.setSecurityContext(new KoffieSecurityContext(subject));
            }catch (Exception ex){
                //eeeuh, tsja, lekker niet de security context setten
            }
        }

    }
}
