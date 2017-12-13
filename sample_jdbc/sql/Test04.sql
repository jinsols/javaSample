select count(*) from emp ;
select count(empno) from emp ;
select count(mgr) from emp ;
select count(comm) from emp ;
select count(distinct job) from emp ;

select sum(sal) from emp ;
select sum(sal) from emp where deptno=10 ;
select sum(sal)/count(empno) from emp ;
select sum(sal),avg(sal),min(sal),max(sal) from emp ;

select avg(sal) from emp ;
select avg(sal) from emp where deptno=10 ;
select avg(sal) from emp where deptno=20 ;
select avg(sal) from emp where deptno=30 ;
 
select avg(sal) from emp group by deptno ;
select deptno, round(avg(sal),'0') from emp group by deptno ;

select e.deptno, dname, round(avg(sal),'0') "avg"
from emp e , dept d
where e.deptno = d.deptno  
group by e.deptno,dname
having avg(sal) > 2000;

#직책이 'CLERK' 아닌 사원에 대한 부서별 급여 합계가 6000이상 출력

select deptno, sum(sal)
from emp
where job <> 'CLERK'
group by deptno
having sum(sal) >= 6000  
order by 2 ;

# 직종별 최고 급여를 급여가 많은 직종 부터 출력

select job, max(sal) 최고급여 
from emp
group by job
order by 최고급여 desc;

#월별 입사자수 구하기

select to_char(hiredate,'mm') ||'월' 입사월,count(empno) || '명' 입사인원
from emp
group by to_char(hiredate,'mm')
order by 입사월 ;

# FORD 보다 급여를 많이 받는 사람의 명단

select sal from emp where ename = 'FORD' ;//3000


select *
from emp
where sal > 3000 

select *
from emp
where sal > (select sal from emp where ename='FORD');


select *
from emp
where sal > (select avg(sal) from emp);

select min(sal) from emp group by deptno

select *
from emp
where sal in (select min(sal) from emp group by deptno)

select ename, sal,deptno
from emp out
where sal> (select avg(sal) from emp where deptno = out.deptno ) ;

# Top3 , Sal
select rownum, ename,sal from emp
select ename, sal from emp order by sal desc

select rownum, ename,sal 
from (select * from emp order by sal desc)
where rownum<4;








