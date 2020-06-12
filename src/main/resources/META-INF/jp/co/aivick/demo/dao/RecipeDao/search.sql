select
    /*%expand*/*
from recipes
where
/*%if name != null*/
	recipe_name
    Like /* "%" + name "%" + */'a'
/*%end*/
/*%if mincal != null*/
	AND
    /*mincal*/200 <= cal
/*%end*/
/*%if maxcal != null*/
	AND
    /*maxcal*/0 >= cal
/*%end*/