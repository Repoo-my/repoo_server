package com.repoo.domain.main.enterprise.presentation;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.presentation.dto.req.RequestEnterprise;
import com.repoo.domain.main.enterprise.presentation.dto.res.ResponseEnterprise;
import com.repoo.domain.main.enterprise.service.CommandEnterpriseService;
import com.repoo.domain.main.enterprise.service.QueryEnterpriseService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    private final CommandEnterpriseService commandEnterpriseService;
    private final QueryEnterpriseService queryEnterpriseService;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    @PutMapping
    public void update(
            @RequestHeader String accessToken,
            @RequestBody RequestEnterprise enterprise
    ) {
        commandEnterpriseService.update(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                enterprise
        );
    }

    @DeleteMapping
    public void delete(
            @RequestHeader String accessToken
    ) {
        commandEnterpriseService.delete(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @GetMapping("/{enterpriseId}")
    public ResponseEnterprise getEnterprise(
            @PathVariable Long enterpriseId
    ){
        return queryEnterpriseService.getEnterpriseById(enterpriseId);
    }

    @GetMapping
    public List<ResponseEnterprise> getEnterprises(){
        return queryEnterpriseService.getAllEnterprise();
    }

}
