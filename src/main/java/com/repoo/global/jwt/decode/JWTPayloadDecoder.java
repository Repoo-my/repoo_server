package com.repoo.global.jwt.decode;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Map;

@Service
public class JWTPayloadDecoder {

    public Long jwtPayloadDecode(String jwt) {
        jwt.substring(jwt.indexOf("."), jwt.length()-1);
        jwt.substring(0, jwt.indexOf("."));

        Base64.Decoder decoder = Base64.getUrlDecoder();
        JsonParser jsonParser = new BasicJsonParser();
        Map<String, Object> jsonArray = jsonParser.parseMap(new String(decoder.decode(jwt)));
        return Long.valueOf(jsonArray.get("sub").toString());
    }

}
