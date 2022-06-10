## DBMS

- MariaDB

## DB 및 계정 생성

```sql
create user sc_user@localhost identified by 'sc_pw';
#select * from user;
create database springclouddb default character set utf8 COLLATE utf8_general_ci;
GRANT ALL privileges ON springclouddb.* TO sc_user@localhost;
flush privileges;
commit;
```