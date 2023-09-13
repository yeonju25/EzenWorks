--커넥션풀
<Resource name="jdbc/myoracle" auth="Container"
						type="javax.sql.DataSource"
						driverClassName="oracle.jdbc.OracleDriver"
						url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
						username="scott" password="tiger" maxTotal="20" maxIdle="10"
						maxWaitMillis="-1" />
						
						
--DB
CREATE table board(
    num number(5) primary key,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readcount number(4) default 0,
    writedate date default sysdate
);

CREATE SEQUENCE board_seq start with 1 increment by 1;

INSERT INTO board(num, name, email , pass, title, content)
VALUES(board_seq.NEXTVAL, '성윤정', 'pinksung@nate.com','1234','첫방문','반갑습니다');
INSERT INTO board(num, name, email , pass, title, content)
VALUES(board_seq.NEXTVAL, '성윤정', 'pinksung@nate.com','1234','김밥','맛있어요');
INSERT INTO board(num, name, email , pass, title, content)
VALUES(board_seq.NEXTVAL, '전수빈', 'raccon@nate.com','3333','고등어','일식입니다');
INSERT INTO board(num, name, email , pass, title, content)
VALUES(board_seq.NEXTVAL, '전원지', 'one@nate.com','1111','갯골마을','돼지삼겹살이 맛있습니다.');

SELECT * FROM board;

commit;