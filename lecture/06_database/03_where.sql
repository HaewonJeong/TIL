# WHERE 조건
-- '조건 필더링'의 역할, 특정 조건에 맞는 레코드만을 선택하는데 사용

-- 1. 비교 연산자 활용(=, <>, >, <=)

SELECT
	menu_name,
    menu_price,
    orderable_status
FROM
	tbl_menu
WHERE
	orderable_status <> 'Y'; -- 해당 테이블과 값이 같지 않은 데이터 TRUE
SELECT
	menu_name,
    menu_price
FROM
	tbl_menu
WHERE
	menu_price < 13000;

-- 2. 논리 연산자(AND, OR)를 활용하여 조건 조합
SELECT
	menu_name,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	orderable_status = 'Y' AND category_code = 10;

-- OR(둘 중 하나라도 TRUE)
-- 가격이 만원 이상이고, 2만 5천원인 메뉴 찾기
SELECT
	menu_name,
    menu_price
FROM
	tbl_menu
WHERE
	menu_price >= 10000 AND menu_price <= 25000;
    
-- BETWEEN 연산자
SELECT
	menu_name,
    menu_price
FROM
	tbl_menu
WHERE
	-- 10000 이상 25000 이하(부정은 NOT을 붙인다)
	menu_price BETWEEN 10000 AND 250000;
    
-- LIKE
-- 메뉴 이름에 '마늘'이 포함된 메뉴 찾고 싶을 때, %는 0개 이상의 모든 문자를 의미하는 와일드 카드
SELECT
	menu_name
FROM
	tbl_menu
WHERE
	menu_name LIKE '%마늘%' ; 
    -- LIKE '%마늘' -- '마늘'로 끝나는 모든 것 (햇마늘, 깐마늘, 의성마늘 등)
    -- LIKE '마늘%' -- 중간에 '마늘'이 들어가는 모든 것

-- IN 연산자 : OR 연산자를 여러 번 쓰는 대신, 괄호 ( ) 안에 찾고 싶은 값들을 쉼표로 나열해서 사용
-- 카테고리 코드가 4번 OR 5번 OR 6번인 메뉴 찾기
SELECT
	menu_name,
    category_code
FROM
	tbl_menu
WHERE
	category_code IN (4,5,6);

-- IS NULL 연산자
-- 데이터베이스에서 NULL은 '0'이나 '빈 문자열'이 아닌, '값이 존재하지 않음'을 의미하는 상태이다. 
-- 상위 카테고리가 없는 (NULL) 카테고리 찾기
SELECT
	category_code,
    category_name,
    ref_category_code
FROM
	tbl_category
WHERE
	ref_category_code IS NULL; -- *부정 : IS NOT NULL
    




    
