package com.zerock.b02.repository;

import com.zerock.b02.domain.Friend;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class FriendRepositoryTests {
    @Autowired
    private FriendRepository friendRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Friend friend = Friend.builder()
                    .name("name" + (i % 10))
                    .phone("phone" + i)
                    .email("email" + i)
                    .address("address" + i)
                    .build();

            Friend result = friendRepository.save(friend);
            log.info("BNO:" + result.getFno());
        });
    }

    @Test
    public void testSelect(){
        Long bno = 99L;
        Optional<Friend> result = friendRepository.findById(bno);

        Friend friend = result.orElseThrow();
        log.info("friend ===>" + friend);
    }

    @Test
    public void testUpdate(){
        Long bno = 100L;
        Optional<Friend> result = friendRepository.findById(bno);
        Friend friend = result.orElseThrow();
        friend.change("수정", "수정", "수정");

        friendRepository.save(friend);
    }

    @Test
    public void testDelete(){
        Long bno = 100L;
        friendRepository.deleteById(bno);
    }

    @Test
    public void testPaging(){
        //1 page order by bno desc
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Friend> result = friendRepository.findAll(pageable);
        log.info("total count : " + result.getTotalElements());
        log.info("total pages : " + result.getTotalPages());
        log.info("page number : " + result.getNumber());
        log.info("page size : " + result.getSize());

        List<Friend> list = result.getContent();
        list.forEach(friend -> log.info(friend));
    }

    @Test
    public void testSearch1(){
        Pageable pageable = PageRequest.of(1,10,Sort.by("bno").descending());
        friendRepository.search1(pageable);
    }

    @Test
    public void testSearchAll(){
        String[] types = {"t", "c", "w"};
        String keyword = "1";
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Friend> result = friendRepository.searchAll(types,keyword,pageable);
    }

    @Test
    public void testSearchAll2(){
        String[] types = {"t", "c", "w"};
        String keyword = "1";
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Friend> result = friendRepository.searchAll(types,keyword,pageable);

        //total pages
        log.info("total pages: " + result.getTotalPages());
        //page size
        log.info("page size : " + result.getSize());
        //pageNumber
        log.info("pageNumber : " + result.getNumber());

        result.getContent().forEach(friend -> log.info(friend));

    }


}