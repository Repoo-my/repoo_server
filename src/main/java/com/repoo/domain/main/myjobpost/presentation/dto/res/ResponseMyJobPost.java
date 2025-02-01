package com.repoo.domain.main.myjobpost.presentation.dto.res;

import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseCurriculumVitae;
import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseDetailCurriculumVitae;
import com.repoo.domain.main.enterprise.presentation.dto.res.ResponseEnterprise;
import com.repoo.domain.main.jobpost.presentation.dto.respoonse.ResponseJobPost;
import com.repoo.domain.main.user.presentation.dto.response.ResponseUserInfo;

public record ResponseMyJobPost(
        Long id,
        ResponseUserInfo user,
        ResponseEnterprise enterprise,
        ResponseJobPost jobPost,
        ResponseCurriculumVitae curriculumVitae,
        Boolean isSubmit
) {
}
