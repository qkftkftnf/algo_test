SELECT NAME,count(name) as count
from ANIMAL_INS
group by name
having count(name)>1
order by name asc;