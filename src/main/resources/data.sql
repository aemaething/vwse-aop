insert into posts
  (id, title, content, cnt, created_at, updated_at)
values
  (RANDOM_UUID(), 'Post #1', 'Hallo, Welt', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


insert into comments
  (id, post_id, content, is_public, cnt, created_at, updated_at)
values
  (RANDOM_UUID(), (select id from posts where title = 'Post #1'), 'So', 1, 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into comments
  (id, post_id, content, is_public, cnt, created_at, updated_at)
values
  (RANDOM_UUID(), (select id from posts where title = 'Post #1'), 'ein', 1, 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into comments
  (id, post_id, content, is_public, cnt, created_at, updated_at)
values
  (RANDOM_UUID(), (select id from posts where title = 'Post #1'), 'Schmarrn!', 1, 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());