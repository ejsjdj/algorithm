select
    ID, case
        when (SIZE_OF_COLONY > 1000) then 'HIGH'
        when (SIZE_OF_COLONY > 100) then 'MEDIUM'
        ELSE 'LOW'
        END AS SIZE
from 
    ECOLI_DATA