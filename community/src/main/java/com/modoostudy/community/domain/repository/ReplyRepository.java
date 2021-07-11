package com.modoostudy.community.domain.repository;

import com.modoostudy.community.domain.entity.replyTB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<replyTB, Long> {

    replyTB findByReplyID(Long replyId);
}
