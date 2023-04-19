package com.bridgelabz.addressbook.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTToken {
    private final String SECRET="Hariprasad";
    public String createToken(int empId){
        String token ;
        token= JWT.create().withClaim("id",empId).sign(Algorithm.HMAC256(SECRET));
        return token;
    }
    public int decodeToken(String token){
        int id=0;
        if(token!=null){
            id=JWT.require(Algorithm.
                            HMAC256(SECRET)).build().
                    verify(token).getClaim("id").
                    asInt();
        }
        return id;
    }
}
