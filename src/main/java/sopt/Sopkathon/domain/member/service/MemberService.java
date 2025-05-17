package sopt.Sopkathon.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.Sopkathon.domain.member.dto.response.MemberResponse;
import sopt.Sopkathon.domain.member.repository.MemberRepository;
import sopt.Sopkathon.global.common.exception.MemberNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse getById(Long id) {
        return memberRepository.findById(id)
                .map(MemberResponse::from)
                .orElseThrow(() -> new MemberNotFoundException(id));
    }
}
