--#3번
select code, name, Continent, region from country c where code = "kor";
--#4번
select code, name, format(gnp,2), format(GNPOld,2), format(gnp-GNPOld,2) as gnp변동량 
from country c where gnp-GNPOld >= 0 order by gnp-GNPOld asc;
--#5번
select distinct continent from country c order by length(continent);
--#6번
select concat(concat(name, '은', Continent),'에 속하며 인구는', concat(' ', Population,'명이다.')) as 정보 
from country c where Continent like '%asia%' order by name;
--#7번
select name, continent, format(gnp,2), population from country c 
where IndepYear is null and Population >= 10000 order by Population asc;

--#8번
select code, name, population from country c 
where 100000000 <= Population and Population <= 200000000 order by Population desc limit 3;

--#9번
select code, name, indepyear from country c 
where IndepYear in (800, 1810, 1811, 1901, 1901) order by IndepYear asc;

--# 10번
select code, name, region from country c where Region like '%asia%' and name like '_o%';

--#11번
select length('홍길동')-6 as 한글, length('hong') as 영문;

--#12번
select code, name, governmentform from country c 
where GovernmentForm like '%republic%'and length(name) >= 10 order by length(name) desc limit 10;

--#13번
select code, name from country c 
where regexp_like (code, '^a|^e|^i|^o|^u') order by name asc limit 2, 3;

--#14번
select name, concat(substring(name, 1, 2), repeat('*', length(name)-4), substring(name, -2)) 
from country c ;

--#15번
select distinct replace(region, ' ', '_') as 지역들 from country c order by length(지역들) desc;

--#16번
select name, format(surfacearea,2), population, round((SurfaceArea / Population), 3) as 1인당점유면적
from country c where Population >= 100000000 order by 1인당점유면적 asc;
