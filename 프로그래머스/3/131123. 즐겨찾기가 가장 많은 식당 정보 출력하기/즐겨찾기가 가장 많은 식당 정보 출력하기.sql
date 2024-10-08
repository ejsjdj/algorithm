SELECT
    A.FOOD_TYPE, REST_ID AS REST_ID, REST_NAME, FAVORITES
FROM 
    REST_INFO A
WHERE
    (FOOD_TYPE, FAVORITES) IN (
        SELECT
            FOOD_TYPE, MAX(FAVORITES)
        FROM
            REST_INFO B
        GROUP BY
            FOOD_TYPE
    )
ORDER BY
    FOOD_TYPE DESC