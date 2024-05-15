package com.app.kream.service;

import com.app.kream.domain.Member;
import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.model.NotFoundException;
import com.app.kream.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMemberById(
            final Long memberId
    ) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }
}
