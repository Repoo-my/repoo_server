package com.repoo.domain.main.myjobpost.presentation;

import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.presentation.dto.req.RequestMyJobPost;
import com.repoo.domain.main.myjobpost.presentation.dto.res.ResponseMyJobPost;
import com.repoo.domain.main.myjobpost.service.CommandMyJobPostService;
import com.repoo.domain.main.myjobpost.service.QueryMyJobPostService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myjobpost")
public class MyJobPostController {

    private final CommandMyJobPostService commandMyJobPostService;
    private final QueryMyJobPostService queryMyJobPostService;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    @PostMapping
    public void createMyJobPost(
            @RequestHeader String accessToken,
            @RequestBody RequestMyJobPost requestMyJobPost
    ) {
        commandMyJobPostService.create(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                requestMyJobPost
        );
    }

    @PutMapping("/{myJobPostId}")
    public void updateMyJobPost(
            @RequestHeader String accessToken,
            @PathVariable Long myJobPostId,
            @RequestBody RequestMyJobPost requestMyJobPost
    ) {
        commandMyJobPostService.update(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                myJobPostId,
                requestMyJobPost
        );
    }

    @DeleteMapping("/{myJobPostId}")
    public void deleteMyJobPost(
            @RequestHeader String accessToken,
            @PathVariable Long myJobPostId
    ) {
        commandMyJobPostService.delete(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                myJobPostId
        );
    }

    @GetMapping
    public List<ResponseMyJobPost> getAllMyJobPost(
            @RequestHeader String accessToken
    ){
        return queryMyJobPostService.getMyJobPosts(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @GetMapping("/{myJobPostId}")
    public ResponseMyJobPost getMyJobPostById(
            @RequestHeader String accessToken,
            @PathVariable Long myJobPostId
    ){
        return queryMyJobPostService.getMyJobPost(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                myJobPostId
        );
    }

}
