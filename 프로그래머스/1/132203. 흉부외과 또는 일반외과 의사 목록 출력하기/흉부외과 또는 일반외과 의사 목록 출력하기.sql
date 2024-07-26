-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, TO_CHAR(HIRE_YMD, 'YYYY-MM-DD') from DOCTOR where MCDP_CD = 'CS' OR MCDP_CD = 'GS' order by HIRE_YMD desc, DR_NAME asc