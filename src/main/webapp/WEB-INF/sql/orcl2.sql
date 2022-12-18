select * from member;
select * from room;

delete from room;
drop sequence room_roomidx_seq;
create sequence room_roomidx_seq;

commit;

select * from(select * from room where roomhost != 'dubu') where rownum <= 10;

delete from room where roomhost = '������';

insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��1', 'tteokbokki', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��2', 'admin1', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��3', 'dubu', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��4', 'zz', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��5', 'lord', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��6', 'zelda', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��7', 'link', 1234, '�⺻');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '��8', 'joshua', 1234, '�⺻');

insert into member(id, password, nickname) values ('tteokbokki', 1234, '������');
insert into member(id, password, nickname) values ('admin1',  1234, '������1');
insert into member(id, password, nickname) values ('dubu',  1234, '�κ�');
insert into member(id, password, nickname) values ('zz',  1234, 'zz');
insert into member(id, password, nickname) values ('lord',  1234, '�ε�');
insert into member(id, password, nickname) values ('zelda',  1234, '����');
insert into member(id, password, nickname) values ('link',  1234, '��ũ');
insert into member(id, password, nickname) values ('joshua',  1234, '����');

insert into friend (mid, fid) values ('test', 'tt');
select * from friend;
rollback;

select count(*) from friend where mid = 'member' and fid = 'member';
delete from friend where mid='member' and fid='member';
commit;
update friend set relation = 'd' where fid = '' or mid = '';


select * from chat;
delete from chat;
drop sequence chat_chatroomidx_seq;
create sequence chat_chatroomidx_seq;
