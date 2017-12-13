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

#��å�� 'CLERK' �ƴ� ����� ���� �μ��� �޿� �հ谡 6000�̻� ���

select deptno, sum(sal)
from emp
where job <> 'CLERK'
group by deptno
having sum(sal) >= 6000  
order by 2 ;

# ������ �ְ� �޿��� �޿��� ���� ���� ���� ���

select job, max(sal) �ְ�޿� 
from emp
group by job
order by �ְ�޿� desc;

#���� �Ի��ڼ� ���ϱ�

select to_char(hiredate,'mm') ||'��' �Ի��,count(empno) || '��' �Ի��ο�
from emp
group by to_char(hiredate,'mm')
order by �Ի�� ;

# FORD ���� �޿��� ���� �޴� ����� ���

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








