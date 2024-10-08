SELECT 
    OUTS.ANIMAL_ID, OUTS.NAME
        FROM ANIMAL_INS INS
        JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
        ORDER BY OUTS.DATETIME - INS.DATETIME DESC
        FETCH FIRST 2 ROWS ONLY;