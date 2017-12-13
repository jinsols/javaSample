select * from EMP;
select * from dept;
select ename,sal,comm,sal+nvl(comm,0) as 급여 from EMP;
select ename,sal,comm,sal+nvl(comm,0) "급 여" from EMP;
select
empno, ename, nvl(to_char(mgr),'No') 
from emp;
select ename, job from emp ;

select ename||' '|| job from emp ;
select ename,99 from emp ;
select dname, sysdate from dept;
select sysdate, user from dual;
select distinct job from emp ;
select distinct job,deptno from emp;

select *from emp where deptno = 30;
select *from emp where sal<=3000;
select *from emp where sal<>3000;
select *from emp where sal!=3000;
select ename,hiredate from emp where sal!= 3000;
select ename,hiredate from emp 
where upper(ename)=upper('smith');

select ename,job from emp where comm is null ;
select ename,job from emp where comm is not null ;

select ename,job,deptno from emp 
where deptno=20 or deptno=30;

select ename,job,deptno from emp 
where deptno=20 and sal < 2000;


select ename,job,deptno from emp 
where deptno in (20,30) ;


select ename,job,deptno from emp 
where deptno = any (20,30) ;

select ename,job,deptno from emp 
where deptno <> all (20,30) ;

select
  *
 from dept ;
 
 
 select *
 from dept
 where (deptno=10 and dname = 'ACCOUNTING') 
 or (deptno=30 and dname = 'SALES') ;
 
 
 select *
 from dept
 where (deptno,dname)
 in((30,'SALES'),(10,'ACCOUNTING')) ;
         
 select ename,sal,job from EMP
 where sal>2500 and sal<=5000 ;
 
select ename,sal,job from EMP
where sal between 2500 and 5000;
 
select * from emp where ename like 'A%' ;
select * from emp where ename like '%E%' ;
select * from emp where ename like '%L_N%' ;
select * from emp where to_date(hiredate) > '1982-01-01';
 
select sysdate , to_char(sysdate,'yyyy') from dual ; 
select sysdate , to_char(sysdate,'yy') from dual ; 
select sysdate , to_char(sysdate,'mm') from dual ; 
select sysdate , to_char(sysdate,'dd') from dual ; 
select sysdate , to_char(sysdate,'day') from dual ; 
 
select ename,hiredate, to_char(hiredate,'day') from emp 
where to_char(hiredate,'mm') = '12' ;
 
select sysdate,66,to_char(66),to_number('66') from dual ; 
select '2017-12-05' from dual; 
select '2017/12/05' from dual; 
select '2017/12/05', to_date('2017/30/12','yyyy/dd/mm') from dual

select * from emp where hiredate > '1982-1-1' ;

select ename,nvl(mgr,0),nvl2(mgr,'Exist','No') from emp ;
select ename, sal from emp ;

select ename,sal,deptno,
decode(deptno,10,sal*1.1,20,sal*1.2,sal)
from emp ;

select * from emp order by deptno ;
select * from emp order by deptno desc,sal ;
select ename,sal from emp order by deptno desc,2 ;

select ename,sal+nvl(comm,0) 급여 from emp oreder by 급여;


select ename,sal,comm,sal+nvl(comm,0), 급여
from emp
where sal+nvl(comm,0)>3000
order by 급여

select ename,dname from emp,dept where emp,deptno=dept.deptno;

select ename,job,dept.deptno,dname,loc 
from emp,DEPT
where emp.deptno = dept.deptno ;


select e.ename,e.job,d.deptno,d.dname,d.loc 
from emp e,DEPT d
where e.deptno(+) = d.deptno ;

select e.ename,e.job,d.deptno,d.dname,d.loc 
from emp e,DEPT d
where e.deptno = d.deptno and d.loc = 'DALLASE' ;


select ename,job, sal+nvl(comm,0) 급여, grade
from emp e,SALGRADE s
where sal+nvl(comm,0) between s.losal and s.hisal ;


select e.ename, m.ename
from emp e, emp m
where e.mgr = m.empno 

select * from tab ;

select e.first_name||e.last_name,c.country_name from employees e, DEPARTMENTS d, LOCATIONS l, COUNTRIES c
where e.department_id = d.department_id and d.location_id = l.location_id and l.country_id= c.country_id;



1.
select e.employee_id, e.last_name, e.hire_date 
from EMPLOYEES e, EMPLOYEES m
where e.department_id=m.department_id and e.hire_date > m.hire_date;

2.
select e.employee_id, e.first_name, d.department_name, m.first_name
from EMPLOYEES e, DEPARTMENTS d, EMPLOYEES m
where e.manager_id = m.employee_id and e.department_id = d.department_id ;

3.
s
















 
 
 













