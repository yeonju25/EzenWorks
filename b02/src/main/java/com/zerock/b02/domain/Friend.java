package com.zerock.b02.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Friend extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @Column(length = 30, nullable = false, updatable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String address;


    public void change(String phone, String email, String address){
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
