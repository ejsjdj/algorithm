SELECT COUNT(*) AS COUNT FROM (
    SELECT (GENOTYPE & 5 >= 1) AND (GENOTYPE & 2 != 2) AS GENOTYPE FROM ECOLI_DATA
) AS SUB
WHERE GENOTYPE = 1;