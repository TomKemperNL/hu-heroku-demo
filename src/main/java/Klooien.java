import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import jerseydemo.KoffieSecurityContext;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Klooien {

    public static void main(String[] args) {
        String token = Jwts.builder()
                .setSubject("tom")
                .signWith(SignatureAlgorithm.HS512, KoffieSecurityContext.key)
                .compact();
        System.out.println(token);

        String valsToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiasdfasdfasdfsJ0b20ifQ.Hjr_ZL4w1PZo2MSXyKDIQWGGYIe7jTq3FieXhkWpkbpd0m9xFdmzUQlqVkpmtTlMyOObeTRNeXZBrAvGJbP3Xg";

        Jws<Claims> claimswut = Jwts.parser().setSigningKey(KoffieSecurityContext.key).parseClaimsJws(valsToken);
        String subject = claimswut.getBody().getSubject();
        System.out.println(subject);
    }
}
