/*DML(Data Manipuliation Language) */
-- INSERT, UPDATE, DELETE

# INSERT
-- 새로운 행 추가(테이블의 행의 수가 증가)
-- 테이블 컬럼 순서에 맞춰 모드 값을 순서대로 제공
INSERT INTO tbl_menu VALUES(null, '바나나해장국', 8500, 4, 'Y');

-- 조회
SELECT * FROM tbl_menu;

-- 특정 컬럼에만 값 추가
INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)
VALUES
	('초콜릿죽',6500,7,'N');
    
-- 한번에 여러 행 추가
INSERT INTO
	tbl_menu
VALUES
	(NULL, '초코맛아이스크림', 1700, 12, 'Y'),
    (NULL, '딸기맛아이스크림', 1700, 12, 'Y'),
    (NULL, '바닐라맛아이스크림', 1700, 12, 'Y');
    
-- UPDATE
-- 테이블에 이미 존재하는 행의 컬럼의 값을 수정
SELECT
	menu_code,
    category_code
FROM
	tbl_menu
WHERE
	menu_name = '바나나해장국';
    
UPDATE tbl_menu
SET -- UPDATE는 SET을 써야함 !!!!!!!!!!!!!!!!!
	category_code = 7 -- 바꿀 내용
WHERE
	menu_code = 22; -- 바꿀 대상

SELECT * FROM tbl_menu;

# DELETE
-- 테이블에서 특정 행을 삭제하는 구문

SELECT * FROM tbl_menu WHERE menu_code = 22;
DELETE FROM
	tbl_menu
WHERE
	menu_code = 22;


