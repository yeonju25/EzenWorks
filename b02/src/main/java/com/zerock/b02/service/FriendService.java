package com.zerock.b02.service;

import com.zerock.b02.dto.FriendDTO;
import com.zerock.b02.dto.PageRequestDTO;
import com.zerock.b02.dto.PageResponseDTO;

public interface FriendService {
    Long register(FriendDTO friendDTO);

    FriendDTO readOne(Long fno);

    void modify(FriendDTO friendDTO);

    void remove(Long fno);

    PageResponseDTO<FriendDTO> list(PageRequestDTO pageRequestDTO);


}
