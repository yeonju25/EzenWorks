package com.zerock.b02.repository;

import com.zerock.b02.domain.Friend;
import com.zerock.b02.repository.search.FriendSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FriendRepository extends JpaRepository<Friend, Long>, FriendSearch {

    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
