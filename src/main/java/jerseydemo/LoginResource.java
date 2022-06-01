package jerseydemo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(Credentials credentials){
        if(credentials.getUsername().equals("tom") && credentials.getPassword().equals("test")){

            String token = Jwts.builder()
                    .setSubject(credentials.getUsername())
                    .signWith(SignatureAlgorithm.HS512, KoffieSecurityContext.key)
                    .compact();

            return Response.ok(new TokenResponse(token)).build();
        }else{
            return Response.status(401).build();
        }
    }
}
