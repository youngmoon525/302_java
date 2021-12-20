
-- 데이터를 조회할 때 명령어, (질의어)
-- 어떤 것을 조회할 것인지 == SELECT COLUMN ( 모든 컬럼 == * )
-- 어디에서 조회를 할 것인지 == FROM TABLE
-- 조회를 할 때 어떤 조건을 줄 것인지 == WHERE
-- HR 계정 <- DataBase(Oracle) 교육용으로 이미 테이블이나 여러가지 스키마들이 있는 상태로 제공되는 것
-- TABLE <- EXCEL
SELECT * -- EMPLOYEE_ID, FIRST_NAME, LAST_NAME
FROM employees
WHERE EMPLOYEE_ID = 100;

-- DEPARTMENTS <- 부서테이블을 전체 조회해보기
-- 대문자로 쓰는 이유는 가독성때문에 Oracle에서 가능한 대문자를 이용하려고함
-- 대문자가 인식이 더 빠름 A = 65, a = 97
SELECT *
FROM DEPARTMENTS;

-- ONE TABLE SELECT < Table <-> Table사이에 유기적인 관계를 만들어서
-- 데이터를 집합구조로 사용하기 위해서임
-- ex) 자바에서 파라메터(인수)를 보냄 -> 인수를 이용해서 해당하는 내용만 조회를 함
--  java -> String id = 'admin', pw = 'admin1234' => employees에 해당하는 내용의 id, pw
-- 가 있는 지를 