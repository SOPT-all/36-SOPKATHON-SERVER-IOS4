package sopt.Sopkathon.domain.member.dto.response;

import sopt.Sopkathon.domain.member.entity.Member;

public record MemberResponse(
        Long id,
        String username,
        String telephone,
        String role
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getUsername(),
                member.getTelephone(),
                member.getRole().name()
        );
    }
}