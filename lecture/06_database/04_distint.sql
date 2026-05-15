# DISTINCT 
-- 중복 값을 제거하고 유니크한 값들의 목록만 출력
-- 특정 컬럼에 어떤 값들이 '종류별로'있는지 확인할 때 유용

SELECT DISTINCT 
	category_code
FROM
	tbl_menu
ORDER BY
	category_code;

-- NULL 값을 포함한 열
SELECT distinct
	ref_category_code
FROM
	tbl_category;
    
-- 열이 여러개인 distinct
-- 지정된 모든 열의 조합이 똑같을 때만 중복으로 간주하여 제거
SELECT distinct
	category_code
    orderable_status
FROM
	tbl_menu;