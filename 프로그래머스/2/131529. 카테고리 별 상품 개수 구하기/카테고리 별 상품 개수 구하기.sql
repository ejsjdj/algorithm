SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY, COUNT(PRODUCT_CODE) AS PRODUCT_COUNT
FROM PRODUCT
GROUP BY SUBSTR(PRODUCT_CODE, 1, 2)
ORDER BY CATEGORY;