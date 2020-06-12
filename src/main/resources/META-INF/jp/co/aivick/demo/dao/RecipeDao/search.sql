select
	/*%expand*/*
from recipe
where
/*%if mincal != null */
cal >=/*mincal*/1
/*%end */

/*%if maxcal != null */
and cal <=/*maxcal*/2
/*% end */

/*%if name != null */
and recipe_name 
Like /* @infix(name) */'a'
/*%end */
