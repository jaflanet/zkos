INSERT INTO role (id,name) VALUES (1,'ROLE_USER');
INSERT INTO role (id,name) VALUES (2,'ROLE_ADMIN');

INSERT INTO userLogin (id, username, password) VALUES (1,'admin','$2a$10$0xLWDXAvkzZ7djx/qgXFE.5L.g8Kth46Q.m000YMyc2Cm8DSp4S9y');
INSERT INTO userLogin (id, username, password) VALUES (2,'user','$2a$10$BrAOSuirdbeKWUy/JM7JV.ymorDB3KhFYlH/YKX3dQiP0973z/B7m');

INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (1,2);
INSERT INTO user_roles (user_id,role_id) VALUES (2,1);

