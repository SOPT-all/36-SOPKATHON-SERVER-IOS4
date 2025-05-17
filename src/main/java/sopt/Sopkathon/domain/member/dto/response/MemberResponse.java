package sopt.Sopkathon.domain.member.dto.response;

import sopt.Sopkathon.domain.member.entity.Member;

public record MemberResponse(
        Long id,
        String telephone,
        String role
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getTelephone(),
                member.getRole().name()
        );
    }
}