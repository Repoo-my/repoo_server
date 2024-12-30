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
            @RequestHeader Map<String, String> headerData
        ){
        return queryCurriculumVitaeService.getCurriculumVitaesByUser(
                jwtPayloadDecoder.jwtPayloadDecode(headerData.get("access_token"))
        );
    }

    @GetMapping("/detail/{curriculumVitaeId}")
    public ResponseDetailCurriculumVitae getCurriculumVitae(
            @RequestHeader Map<String, String> headerData,
            @PathVariable Long curriculumVitaeId
    ){
        return queryCurriculumVitaeService.getCurriculumVitae(
                jwtPayloadDecoder.jwtPayloadDecode(headerData.get("access_token")),
                curriculumVitaeId
        );
    }

    @PostMapping("/")
    public void createCurriculumVitae(
            @RequestHeader Map<String, String> headerData,
            @RequestBody RequestCurriculumVitae requestCurriculumVitae,
            @RequestBody RequestEducation requestEducation,
            @RequestBody RequestCareer requestCareer,
            @RequestBody RequestLanguage requestLanguage
        ){
        commandCurriculumVitaeService.save(
                jwtPayloadDecoder.jwtPayloadDecode(headerData.get("access_token")),
                requestCurriculumVitae,
                requestEducation,
                requestCareer,
                requestLanguage
        );
    }

    @PutMapping("/detail/{curriculumVitaeId}")
    public void updateCurriculumVitae(
        @RequestHeader Map<String, String> headerData,
        @PathVariable Long curriculumVitaeId,
        @RequestBody RequestCurriculumVitae requestCurriculumVitae,
        @RequestBody RequestEducation requestEducation,
        @RequestBody RequestCareer requestCareer,
        @RequestBody RequestLanguage requestLanguage
    ){
        commandCurriculumVitaeService.update(
            curriculumVitaeId,
            jwtPayloadDecoder.jwtPayloadDecode(headerData.get("access_token")),
            requestCurriculumVitae,
            requestEducation,
            requestCareer,
            requestLanguage
        );
    }

    @DeleteMapping("/detail/{curriculumVitaeId}")
    public void deleteCurriculumVitae(
        @RequestHeader Map<String, String> headerData,
        @PathVariable Long curriculumVitaeId
    ){
        commandCurriculumVitaeService.delete(
            curriculumVitaeId,
            jwtPayloadDecoder.jwtPayloadDecode(headerData.get("access_token"))
        );
    }

}
