#SUBQUERIS(서브쿼리)

-- 민트 미역국의 같은 다른 메뉴들을 조회
-- 민트 미역국의 카테고리코드를 알아낸다
SELECT
	category_code
FROM
	tbl_menu
WHERE
	menu_name = '민트미역국';
    
-- 메인 쿼리
-- 민트미역국과 같은 카테고리의 메뉴 조회
SELECT
	menu_name,
    category_code
FROM
	tbl_menu
WHERE
	category_code = 4;
    
-- 서브 쿼리
-- WHERE 절에 () 소괄호 넣고 메인쿼리 안에 서브쿼리 삽입
SELECT
	menu_name,
    category_code
FROM
	tbl_menu
WHERE
	category_code = (SELECT 
							category_code
						FROM
							tbl_menu
						WHERE
							menu_name = '민트미역국');

-- FROM 절에 서브쿼리 사용
-- 즉석에서 만들어 쓰는 임시 테이블 처럼 동작 --> 파생 테이블 이라고도 부름

-- 가장 많은 메뉴가 포함된 카테고리는 메뉴를 총 몇개 가지고 있을까?
-- (서브 쿼리) : 카테고리 별로 메뉴가 총 몇 개씩 있는지?

SELECT
	COUNT(*) AS 'count'
FROM
	tbl_menu
GROUP BY
	category_code;
    
-- 가장 많은 메뉴가 포함된 카테고리의 메뉴 수
SELECT
	MAX(count) AS '최대 메뉴 수'
FROM
	(SELECT
		COUNT(*) AS 'count'
	FROM
		tbl_menu
	GROUP BY
		category_code) AS count_table; -- 파생 테이블은 반드시 별칭이 있어야 한다.

-- 상관 서브쿼리(심화)
-- 카테고리별 평균 가격보다 높은 가격의 메뉴 조회
SELECT
	AVG(menu_price)
FROM
	tbl_menu
WHERE
	category_code = 4;
    
SELECT
		menu_code,
        menu_name,
        menu_price
FROM
	tbl_menu
    

SELECT
		menu_code,
        menu_name,
        menu_price
        category_code
FROM
	tbl_menu a
WHERE
	menu_price > (SELECT
						AVG(menu_price)
					FROM
						tbl_menu
					WHERE
						-- a.category_code : 바깥쪽 쿼리에서 현재 보고 있는 메뉴의 카테고리 코드       
						category_code = a.category_code); 

-- UINION : 두 결과를 합치기(중복은 제거)
-- 카테고리 코드가 10번인 메뉴들
-- 가격이 9,000원 미만인 메뉴들
/*FROM
	tbl_menu
WHERE
	category_code = 10
UNION ALL
SELECT
	menu*/

/*교집합 : INNER JOIN*/
-- INNER JOIN 활용
SELECT
	a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code
FROM
	tbl_menu a
INNER JOIN ( SELECT 
				menu_code,
				menu_name,
                menu_price,
                category_code
			FROM
				tbl_menu
			WHERE
				menu_price < 9000) b on (a.menu_code = b.menu_code) -- 파생 테이블 별칭 필요
WHERE
	a.category_code = 10;
-- IN 연산자 활용
SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code
FROM
	tbl_menu
WHERE
	category_code = 10 AND menu_code IN (SELECT
											menu_code
										FROM
											tbl_menu
										WHERE
											menu_price < 9000);
/*MINUS(차집합)*/
-- LEFT JOIN 사용
SELECT
	a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code
FROM
	tbl_menu a
INNER JOIN (SELECT
				menu_code,
                menu_name,
                menu_price,
                category_code
			FROM
				tbl_menu
			WHERE
				menu_price < 9000)  on (a.menu_code = b.menu_code)
WHERE
	a.category_code = 10 AND b.menu_code IS NULL;
                
										
                                        


    

