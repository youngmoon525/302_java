-- SELECT, INSERT, UPDATE, DELETE
-- 한번식 사용해서 Board테이블 조회해보고, 행추가, 행수정, 행삭제,
-- SELECT <- 행을 조회(트랜잭션이 발생안함, 임시데이터 x)
-- INSERT, UPDATE, DELETE(트랜잭션 발생 => COMMIT, ROLLBACK)
CREATE TABLE BOARD (
    no number primary key,
    title varchar2(3000),
    content varchar2(1000)
);

-- SELECT FROM -> WHERE (선택)
-- UPDATE SET -> WHERE (선택이지만 대부분 반드시 사용함, 테이블 전체데이터가 수정됨)
-- INSERT INTO VALUES
-- DELETE FROM -> WHERE (선택)

-- 데이터가 10건 이상 있게 테이블에 데이터를 추가하기. !

SELECT * FROM board;

UPDATE BOARD SET TITLE = '제목', CONTENT = '내용'
WHERE NO = 3;
ROLLBACK;
DELETE FROM BOARD WHERE NO = 3;
COMMIT;
-- NUMBER형태로 되어있는 컬럼을 자동으로 증가시키는 SEQ, TRIGGER(트랜잭션이 일어날 때 전후 처리)
-- ↑Database서 중요한 내용.
INSERT INTO BOARD ( NO, TITLE, CONTENT)
VALUES(2, 'TITLE2', 'CONTENT2'); -- 컬럼이 많은 경우에는 모든 데이터를 넘겨주지 않아도 될 때.
                                -- 컬럼을 명시해주는 게 유리함.
                                


INSERT INTO board VALUES(2, '제목', 'ㅈㄱㄴ'); -- 모든 컬럼에 넘길 값이 있어야만 사용가능

INSERT INTO board VALUES(4, '애플', '페어');
INSERT INTO board VALUES(5, '아이패드', '사고싶다');
INSERT INTO board VALUES(6, 'GSM', '진짜 ;;');
INSERT INTO board VALUES(7, '라면', '라면이라면');
INSERT INTO board VALUES(8, 'GetComponent', 'Rigidbody');
INSERT INTO board VALUES(9, 'Unity', '결속');
INSERT INTO board VALUES(10, '77ㅓ억', '배불러..');

SELECT * FROM BOARD WHERE 1 = 1 ORDER BY NO DESC;
 -- ASC 오른차순 정렬 ( 컬럼을 기준으로 ), DESC 내림차순 정렬
                        -- 게시판에 가져가서
                        
COMMIT;