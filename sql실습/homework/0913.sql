use world;

#1번
select curdate() 오늘, dayofyear(now()) '올해 지난 날', adddate(curdate(), 100) '100일 후'
from dual;

#2번
select name, continent, lifeexpectancy, if(lifeexpectancy > 80, "장수국가", 
if(lifeexpectancy > 60, "일반국가", "단명국가")) as `구분` from country 
where lifeexpectancy is not null and continent="Asia" order by lifeexpectancy;

#3번
select name, gnp, gnpold, if(gnpold is null, 
"신규", gnp-gnpold) as `gnp 향상` from country 
order by name;

#4번
select weekday('2020-05-05'),
       case when weekday('2020-05-05') in(1,2)
            then '행복'
            else '불행'
        end '행복여부';

#5번 
select count(*) as '전체',
       count(IndepYear) as '독립 연도 보유'
from country;

#6번
select sum(LifeExpectancy) as '합계', avg(LifeExpectancy) as '평균', 
max(LifeExpectancy) as '최대', min(LifeExpectancy) as '최소' 
from country c ;

-- 7번
select continent, count(continent) as '국가 수', sum(Population) as '인구 합'
from country
group by continent
order by count(continent) desc
limit 7;

-- 8번
select continent, sum(SurfaceArea) as '표면적 합' from country c 
group by continent
order by sum(SurfaceArea) desc
limit 3;

-- 9번
select continent, sum(GNP) as 'gnp 합' from country c
where Population >= 50000000
group by continent
order by sum(GNP) asc;

-- 10번
select Continent, sum(GNP) 'gnp 합' from country
where Population >= 50000000
group by Continent having sum(gnp) >= 5000000;

-- 11번
select IndepYear, count(IndepYear) as '독립 국가 수'
from country
group by IndepYear
having count(indepyear) >= 10;

-- 12번
select i.Continent, i.Name, i.GNP, (select avg(GNP) from country) "전세계 평균", o.av "대륙 평균"
from country as i, (select Continent, avg(GNP) av from country group by Continent) as o
where i.Continent = o.Continent
order by i.Continent;
