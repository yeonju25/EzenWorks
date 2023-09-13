package com.zerock.b02.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.zerock.b02.domain.Friend;

import com.zerock.b02.domain.QFriend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FriendSearchImpl extends QuerydslRepositorySupport implements FriendSearch {

    public FriendSearchImpl(){
        super(Friend.class);
    }


    @Override
    public Page<Friend> search1(Pageable pageable) {
        QFriend friend = QFriend.friend;
        JPQLQuery<Friend> query = from(friend);
        query.where(friend.phone.contains("1"));
        this.getQuerydsl().applyPagination(pageable,query);

        List<Friend> list = query.fetch();
        long count = query.fetchCount();

        return null;
    }

    @Override
    public Page<Friend> searchAll(String[] types, String keyword, Pageable pageable) {
        QFriend friend = QFriend.friend;
        JPQLQuery<Friend> query = from(friend);
        if((types != null && types.length > 0) && keyword != null){ // 검색조건과 키워드가 있다면
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for(String type: types){
                switch (type){
                    case "n":
                        booleanBuilder.or(friend.name.contains(keyword));
                        break;
                    case "p":
                        booleanBuilder.or(friend.phone.contains(keyword));
                        break;
                    case "e":
                        booleanBuilder.or(friend.email.contains(keyword));
                        break;
                    case "a":
                        booleanBuilder.or(friend.address.contains(keyword));
                        break;

                }
            }//end for
            query.where(booleanBuilder);
        }//end if

        //bno=0
        query.where(friend.fno.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Friend> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }

}
