package com.repoo.domain.curriculumvitae.presentation;

import com.repoo.domain.curriculumvitae.presentation.dto.request.RequestCareer;
import com.repoo.domain.curriculumvitae.presentation.dto.request.RequestCurriculumVitae;
import com.repoo.domain.curriculumvitae.presentation.dto.request.RequestEducation;
import com.repoo.domain.curriculumvitae.presentation.dto.request.RequestLanguage;
import com.repoo.domain.curriculumvitae.presentation.dto.response.ResponseCurriculumVitae;
import com.repoo.domain.curriculumvitae.presentation.dto.response.ResponseDetailCurriculumVitae;
import com.repoo.domain.curriculumvitae.service.CommandCurriculumVitaeService;
import com.repoo.domain.curriculumvitae.service.QueryCurriculumVitaeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/curriculumvitae")
public class CurriculumVitaeController {

    private final CommandCurriculumVitaeService commandCurriculumVitaeService;
    private final QueryCurriculumVitaeService queryCurriculumVitaeService;

    @GetMapping("/")
    public List<ResponseCurriculumVitae> getCurriculumVitaes(
            @RequestParam Long userId
    ){
        return queryCurriculumVitaeService.getCurriculumVitaesByUser(userId);
    }

    @GetMapping("/detail/{curriculumVitaeId}")
    public ResponseDetailCurriculumVitae getCurriculumVitae(
            @RequestParam Long userId,
            @PathVariable Long curriculumVitaeId
    ){
        return queryCurriculumVitaeService.getCurriculumVitae(userId, curriculumVitaeId);
    }

    @PostMapping("/")
    public void createCurriculumVitae(
            @RequestParam Long userId,
            @RequestBody RequestCurriculumVitae requestCurriculumVitae,
            @RequestBody RequestEducation requestEducation,
            @RequestBody RequestCareer requestCareer,
            @RequestBody RequestLanguage requestLanguage
            ){
        commandCurriculumVitaeService.save(userId, requestCurriculumVitae, requestEducation, requestCareer, requestLanguage);
    }

}
