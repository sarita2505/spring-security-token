--INSERT INTO users(username,password,enabled)
-- VALUES('ram','$2a$12$..VWWxflzVqeMte4DDmG7O0vf2tp.afMPUv/HFhT9EbuMg0dg6dSW',true);
--
-- INSERT INTO users(username,password,enabled)
--  VALUES('sita','$2a$12$Kn6ynD7kwkU6dgNoKorhvOZNPik1eDuHLOv4CqU5av0btBW5ydZ9y',true);

INSERT INTO users(username,password,enabled)
VALUES('ram','ram',true);

INSERT INTO users(username,password,enabled)
 VALUES('sita','sita',true);

  INSERT INTO authorities(username,authority)
   VALUES('ram','ROLE_ADMIN');

   INSERT INTO authorities(username,authority)
      VALUES('sita','ROLE_USER');