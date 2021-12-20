-- 주석
-- DML : ( Data Manipulation Language ) : 데이터베이스에 들어있는 데이터를 조회하거나 데이터에 접근해 변형을 가하는 종류의 질의어를 사용하는 것
-- SELECT, INSERT, UPDATE, DELETE == CRUD ( Create, Read, Update, Delete)
-- 개발자가 많이 사용함 ( 데이터 조작어 )

-- DDL : ( Data Definition Language ) : 테이블과 같은 데이터 구조를 (스키마) 정의하는데 사용되는 명령어들
-- CREATE, ALTER, DROP, RENAME, TRUNCATE ( 생성, 변경, 삭제, 이름변경, 잘라내기 )
-- 개발자보다는 컨설턴트들이 많이 사용함 ( 설계를 할 때 많이 사용이 됨 )

-- DCL : ( Data Control Language ) : 데이터베이스에 접근하고 객체들을 사용하도록 '권한'을 부여하거나 회수하는 등의 보안관련 조작어
-- GRANT, REVOKE ( DBA Data Base Admin )

-- TCL : ( Transaction Control Language ) : 논리적인 작업 단위를 묶어서 DML에 의해 조작된 결과를 별도로 제어하는 명령어를 말함
-- COMMIT (확인), ROLLBACK (취소), SAVEPOINT (저장지점)
-- 조회 해라, * == 전체를 뜻함(열의 갯수)
-- 어디서?
SELECT *
FROM EMPLOYEES ;
