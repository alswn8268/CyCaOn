select * from member;
select * from room;

delete from room;
drop sequence room_roomidx_seq;
create sequence room_roomidx_seq;

commit;

select * from(select * from room where roomhost != 'dubu') where rownum <= 10;

delete from room where roomhost = '떡볶이';

insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방1', 'tteokbokki', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방2', 'admin1', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방3', 'dubu', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방4', 'zz', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방5', 'lord', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방6', 'zelda', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방7', 'link', 1234, '기본');
insert into room (roomidx, roomname, roomhost, roompassword, roomtheme) values (room_roomidx_seq.nextval, '방8', 'joshua', 1234, '기본');

insert into member(id, password, nickname) values ('tteokbokki', 1234, '떡볶이');
insert into member(id, password, nickname) values ('admin1',  1234, '관리자1');
insert into member(id, password, nickname) values ('dubu',  1234, '두부');
insert into member(id, password, nickname) values ('zz',  1234, 'zz');
insert into member(id, password, nickname) values ('lord',  1234, '로드');
insert into member(id, password, nickname) values ('zelda',  1234, '젤다');
insert into member(id, password, nickname) values ('link',  1234, '링크');
insert into member(id, password, nickname) values ('joshua',  1234, '조샤');

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
