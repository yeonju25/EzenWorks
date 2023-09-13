package com.zerock.b02.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Long fno;

    private String name;

    private String phone;

    private String email;

    private String address;

    private LocalDateTime regDate;

    private LocalDateTime modDate;
}
