package com.zerock.b02.service;

import com.zerock.b02.domain.Friend;
import com.zerock.b02.dto.FriendDTO;
import com.zerock.b02.dto.PageRequestDTO;
import com.zerock.b02.dto.PageResponseDTO;
import com.zerock.b02.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FriendServiceImpl implements FriendService{
    private final ModelMapper modelMapper;

    private final FriendRepository friendRepository;

    @Override
    public Long register(FriendDTO friendDTO) {

        Friend friend = modelMapper.map(friendDTO, Friend.class);

        Long fno = friendRepository.save(friend).getFno();

        return fno;
    }

    @Override
    public FriendDTO readOne(Long fno) {
        Optional<Friend> result = friendRepository.findById(fno);
        Friend friend = result.orElseThrow();

        FriendDTO friendDTO = modelMapper.map(friend, FriendDTO.class);

        return friendDTO;
    }

    @Override
    public void modify(FriendDTO friendDTO) {
        Optional<Friend> result = friendRepository.findById(friendDTO.getFno());

        Friend friend = result.orElseThrow();
        friend.change(friendDTO.getPhone(), friend.getEmail(), friend.getAddress());
        friendRepository.save(friend);
    }

    @Override
    public void remove(Long fno) {
        friendRepository.deleteById(fno);
    }

    @Override
    public PageResponseDTO<FriendDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("fno");

        Page<Friend> result = friendRepository.searchAll(types, keyword, pageable);

        List<FriendDTO> dtoList = result.getContent().stream()
                .map(friend -> modelMapper.map(friend, FriendDTO.class)).collect(Collectors.toList());

        return PageResponseDTO.<FriendDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
}
