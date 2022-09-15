-- join : 2개 이상의 테이블을 연결하여 데이터를 조회하는 방법
-- 1:n

delete from dept where deptno = 10;


-- 조인 조건에 따라
-- equi join : 조인조건이 동등비교
-- non-equi join : 조인조건이 동등비교가 아닌 경우

-- 조인 결과에 따라 
-- inner join : 조인조건에 부합하는 대상만 조회
-- outer join : 조인조건에 부합하지 않는 대상도 모두 같이 조회, 기준테이블

-- self join : 레코드가 계층형 성질을 갖고 있는 경우의 조인

-- cross join : 테이블이 레코드들을 연결가능한ㅇ 모든 경우를 다 고려해서 조회하는 방법
 
-- natural join : 두 테이블의 공통 칼럼들을 모두 조인조건으로 하여 하는 조인

select empno, ename, dname 
from emp, dept
where emp.deptno = dept.deptno;

select empno, ename, dname 
from emp
join dept using(deptno);

select e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno;

select e.empno, e.ename, d.deptno, d.dname
from emp e
join dept d on (e.deptno = d.deptno);

-- non-equi join
select e.empno, e.ename, e.sal, s.grade
from    emp e
join     salgrade s on(e.sal between s.losal and s.hisal);

-- self join 
-- 모든 사원의 이름과 사원의 상사이름을 함께 조회
select e.ename, m.ename
from     emp e
join    emp m on (e.mgr = m.empno);

-- outer join
-- 상사가 없는 직원까지 조회
select e.ename, m.ename
from emp e
left join    emp m on (e.mgr = m.empno);

select e.ename, m.ename
from    emp m right outer join    emp e on (e.mgr = m.empno);

-- 안시가 아닌것
-- select e.ename, m.ename
-- from emp e, emp m
-- where e.mgr = m.empno(+); 
-- +를 널이라고 생각하면 된다.

update emp 
set sal = 20000
where empno = 9999;

select e.empno, e.ename, e.sal, s.grade
from     emp e
left join salgrade s on(e.sal between s.losal and s.hisal);

-- 상사인 직원 조회
-- 윤환이꺼 (group by 없어도 됨)
select  distinct s.ename from emp s
inner join emp e
on s.empno = e.mgr
group by s.empno;

-- 진석이 꺼 
select distinct m.ename
from emp m
join emp e on (e.mgr = m.empno);

-- 쌤꺼
select distinct (m.ename)
from    emp m
join     emp e on (m.empno = e.mgr);