drop table book ;

create table book(
     id NUMBER(5) primary key ,
     name varchar2(20) not null,
     price number(10,2)  check(price>0),
     pub_date date default sysdate
     
) ;

insert into book (id,name,price,pub_date)
       values (1,'jsp',9000,sysdate) ;

select * from book;


insert into book (id,name,price,pub_date)
       values (2,'java',9000,sysdate) ;
       
       
select * from book ;
 
insert into book values(1,'jsp',9000,sysdate) 




