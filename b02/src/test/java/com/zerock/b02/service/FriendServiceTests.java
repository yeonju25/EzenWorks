package com.zerock.b02.service;

import com.zerock.b02.dto.FriendDTO;
import com.zerock.b02.dto.PageRequestDTO;
import com.zerock.b02.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class FriendServiceTests {
    @Autowired
    private FriendService friendService;

    @Test
    public void testRegister(){
        log.info(friendService.getClass().getName());
        FriendDTO friendDTO = FriendDTO.builder()
                .name("샘플이름")
                .phone("전화번호")
                .email("이메일")
                .address("주소")
                .build();

        Long fno = friendService.register(friendDTO);

        log.info("fno : " + fno);
    }

    @Test
    public void testModify(){
        FriendDTO friendDTO = FriendDTO.builder()
                .fno(101L)
                .phone("수정번호")
                .email("수정 이메일")
                .address("수정 주소")
                .build();
        friendService.modify(friendDTO);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("npea")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<FriendDTO> responseDTO = friendService.list(pageRequestDTO);
        log.info(responseDTO);
    }



}