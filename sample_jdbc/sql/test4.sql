drop table book;

create table book(
id number(5) primary key,
name varchar2(20) not null,
price number(10,2) check(price>0),
pub_date date default sysdate
);

select * from book

insert into book values(1,'jsp',9000,sysdate)
insert into book values(2,'java',9000,sysdate)
insert into book values(3,'db',5000,sysdate)
insert into book values(4,'sql',2000,sysdate)
insert into book values(5,'seclvet',6000,'2011/09/10')

insert into book values(6,'servlet',null,null)

select * from book
rollback;
commit


select * from emp

insert into emp values(2000,'sungeun','clerk',1000,sysdate,5000,5000,50)
delete 
rollback


select * from dept
commit
insert into dept values(50,'기술부','SEOUL')
commit

update book set pub_date='2014-04-04' ;
rollback

update book set pub_date='2014-04-04' where id=1 ;
select * from book;

commit 
update book set price=7000, pub_date='2002-07-14' where id=2 ;

delete from book where id =1 ;
commit

delete from dept where deptno=50 ;
delete from emp where deptno=50 ;

commit

----------예제
1.
select deptno, empno, ename, sal
from emp
where (deptno, sal) in (select deptno, max(sal)
                        from emp group by deptno) ;
                        
2.
select e.deptno, e.empno, e.ename, e.sal
from emp e, (select s.deptno, max(s.sal) msal from emp s group by deptno) m
where e.deptno = m.deptno and e.sal = m.msal ;

3.
select deptno, empno, ename, sal
from emp e
where e.sal = (select max(sal) from emp where deptno = e.deptno) ;

                        
                        







































