-- Table을 만들기
-- private int no; // 게시글의 번호
-- private String title; // 게시글의 제목
-- private String content; // 게시글의 내용
-- 실행할 부분만 marking 마우스 드래그, ctrl + enter;

CREATE TABLE board (
    no number,
    title varchar2(100),
    content varchar2(3000)
); -- 잘못만든 테이블↑

-- 데이터를 넣는 방법, CRUD, SELECT == READ, CREATE = INSERT
-- INSERT <- 데이터를 추가
INSERT INTO board values(1, 'title', 'content');
-- ↑ 컬럼명을 별도로 지정하지 않고 바로 values를 사용해서 편하지만
-- 모든 컬럼에 값을 넘겨줄 수 있게 해줘야만 insert가 됨 => 컬럼 갯수가 3개면 3개의 데이터를 넘겨줘야 함
INSERT INTO BOARD (no, title, content)
            values (1, 'title', 'content');
-- ↑ 칼럼명을 별도로 지정해서 내가 넣고싶은 칼럼에 넣고 싶은 데이터만 넣을 수 있지만
-- 컬럼명을 별도로 써줘야하니까 불편한 점이 있음. 두개의 실행결과는 같음.
-- 트랜잭션 ( 작업 ) DB에서는 작업을 하고나서 바로 작업을 완료하는 게 아님.
-- 완료는 COMMIT, 취소 ROLLBACK, ****** insert, update, delete 작업 후 반드시
SELECT * FROM BOARD;
COMMIT;
ROLLBACK;
-- 실제 게시글 BOARD
-- ex) 게시글을 로그인을 하고 수정을 했음 content(내용) => content content
-- UPDATE TABLE 명
-- SET COL_NAME = '바꿀값' <= 자바에서 보내줌
-- WHERE COL_NAME = '비교할 값'
UPDATE BOARD
SET CONTENT = 'CONTENT CONTENT'
WHERE NO = 1;
ROLLBACK;
-- 식별자 (key) 데이터를 구분하기위한 값이 빠짐 ( 중복됨 ) == 중복을 허용하면 안됨
-- ex) 주민등록번호, 주소, ...
-- 중복되도 되는 값 : 이름, 나이, 성별, .. 대부분의 것
-- INSERT 데이터 추가, UPDATE 데이터 수정, DELETE 데이터 삭제 <- '데이터' 행
-- DELETE FROM TABLE이름 WHERE 어떤컬럼 = 값
DELETE FROM BOARD WHERE NO = 1;
COMMIT;

-- DATABASE에서 유일하게 식별할 수 있는 컬럼을 KEY가 되는 컬럼
-- KEY ( PRIMARY KEY ) 기본키 ( 중복을 허용하지 않는 칼럼을 만듬) ex) 글 번호, 주민등록번호, 주소
-- 테이블 삭제
DROP TABLE BOARD;

CREATE TABLE BOARD (
    no number primary key,
    title varchar2(100),
    content varchar2(3000)
);

-- 인서트를 두 번 다시 해보기. 똑같은 no로 삽입이 되는지
INSERT INTO board values(2, 'title', 'content') ;
commit;
select * from BOARD;
-- 1번 글의 내용을 content => '글내용으로 수정'
-- 2번 글은 삭제 처리, ※ COMMIT, ROLLBACK을 반드시 생각할 것.
-- 글 추가 3번 내용이나 title은 자유롭게 추가하면 됨.
UPDATE BOARD
set CONTENT = '글내용으로 수정'
WHERE NO = 1;

DELETE FROM BOARD WHERE NO = 2;

INSERT INTO board values(3, '타이틀', '컨텐츠');

SELECT * FROM board;

COMMIT;

-- 자판기 프로그램
-- 음료 목록 조회 - SELECT * FROM DRINK
-- 음료 추가 (DTO) => INSERT INTO
-- 음료 수정 (DTO) => UPDATE
-- 음료 삭제 NO => DELETE

-- DUAL == 가상테이블 ( 간단하게 어떤 수를 더하거나, 데이터를 조회를 해야할 때 실제 테이블 x )

SELECT 1+1
FROM DUAL;
-- JAVA -> DATABASE연결 -> 바로 DATA
