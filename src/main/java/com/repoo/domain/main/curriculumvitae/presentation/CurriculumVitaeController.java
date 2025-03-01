package com.repoo.domain.main.curriculumvitae.presentation;

import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestCareer;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestCurriculumVitae;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestEducation;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestLanguage;
import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseCurriculumVitae;
import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseDetailCurriculumVitae;
import com.repoo.domain.main.curriculumvitae.service.CommandCurriculumVitaeService;
import com.repoo.domain.main.curriculumvitae.service.QueryCurriculumVitaeService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/curriculumvitae")
public class CurriculumVitaeController {

    private final CommandCurriculumVitaeService commandCurriculumVitaeService;
    private final QueryCurriculumVitaeService queryCurriculumVitaeService;
    private final JWTPayloadDecoder jwtPayloadDecoder;

    @GetMapping("/")
    public List<ResponseCurriculumVitae> getCurriculumVitaes(
            @RequestHeader String accessToken
        ){
        return queryCurriculumVitaeService.getCurriculumVitaesByUser(
                jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @GetMapping("/detail/{curriculumVitaeId}")
    public ResponseDetailCurriculumVitae getCurriculumVitae(
            @RequestHeader String accessToken,
            @PathVariable Long curriculumVitaeId
    ){
        return queryCurriculumVitaeService.getCurriculumVitae(
                jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                curriculumVitaeId
        );
    }

    @PostMapping("/")
    public void createCurriculumVitae(
            @RequestHeader String accessToken,
            @RequestBody RequestCurriculumVitae requestCurriculumVitae
        ){
        commandCurriculumVitaeService.save(
                jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                requestCurriculumVitae
        );
    }

    @PutMapping("/detail/{curriculumVitaeId}")
    public void updateCurriculumVitae(
        @RequestHeader String accessToken,
        @PathVariable Long curriculumVitaeId,
        @RequestBody RequestCurriculumVitae requestCurriculumVitae
    ){
        commandCurriculumVitaeService.update(
            curriculumVitaeId,
            jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
            requestCurriculumVitae
        );
    }

    @DeleteMapping("/detail/{curriculumVitaeId}")
    public void deleteCurriculumVitae(
        @RequestHeader String accessToken,
        @PathVariable Long curriculumVitaeId
    ){
        commandCurriculumVitaeService.delete(
            curriculumVitaeId,
            jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

}
