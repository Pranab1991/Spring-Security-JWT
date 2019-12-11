Insert into user values(1,'pranab@gmail.com',true,'pranab','pranab');
Insert into user values(2,'test@gmail.com',true,'test','test');
Insert into user values(3,'admin@gmail.com',true,'admin','admin');

Insert into authorities values(1,'ROLE_USER');
Insert into authorities values(2,'ROLE_ADMIN');

Insert into user_authority values(1,1);
Insert into user_authority values(1,2);
Insert into user_authority values(2,1);
Insert into user_authority values(3,1);