insert into product (name,price,stock_quantity) values ('진짜 진짜 풍미 깊은 아메리카노',10000,23);
insert into product (name,price,stock_quantity) values ('몬스터 제로',10000,23);
insert into product (name,price,stock_quantity) values ('제로콜라 무료배송 12만원이상시 혜택부여',2000,2233);
insert into product (name,price,stock_quantity) values ('해남 고구마 3kg 2박스',12000,283);
insert into product (name,price,stock_quantity) values ('이천 오렌지',7000,593);
insert into product (name,price,stock_quantity) values ('베이크드 빈 12kg 대형',10000,23);
INSERT INTO product (name, price, stock_quantity) VALUES ('나이키 에어포스 1', 129000, 12);
INSERT INTO product (name, price, stock_quantity) VALUES ('맥북 프로 14인치', 2790000, 5);
INSERT INTO product (name, price, stock_quantity) VALUES ('삼성 갤럭시 Z 플립6', 1390000, 8);
INSERT INTO product (name, price, stock_quantity) VALUES ('스타벅스 아메리카노 T', 4500, 300);
INSERT INTO product (name, price, stock_quantity) VALUES ('PS5 디스크 에디션', 759000, 7);
INSERT INTO product (name, price, stock_quantity) VALUES ('롯데 꼬깔콘 큰사이즈', 1800, 250);
INSERT INTO product (name, price, stock_quantity) VALUES ('샤오미 전동 킥보드', 499000, 15);
INSERT INTO product (name, price, stock_quantity) VALUES ('쿠쿠 전기밥솥 10인용', 189000, 20);

insert into discount_policy_entity (discount_type, discount_value, product_id) values ('RATE', 10, 1);
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('FIXED', 5000, 2);
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('RATE', 15, 3);
-- Product 4: 할인 없음
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('COUPON', 2000, 5);
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('FIXED', 10000, 6);
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('RATE', 5, 7);
-- Product 8: 할인 없음
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('COUPON', 30000, 9);
insert into discount_policy_entity (discount_type, discount_value, product_id) values ('RATE', 20, 10);


-- ProductDescription 더미 데이터
INSERT INTO product_description (description, product_id) VALUES
('최고급 원두로 만든 깊고 풍부한 아메리카노입니다.', 1),
('따뜻한 우유 거품과 진한 에스프레소가 어우러진 카푸치노.', 2),
('부드럽고 달콤한 바닐라 라떼.', 3),
('깔끔한 아이스 티와 상큼한 레몬향.', 4),
('초콜릿 풍미 가득한 핫초코 음료.', 5),
('시원하고 상쾌한 아이스 아메리카노.', 6),
('허브향이 진한 따뜻한 카모마일 티.', 7),
('카라멜 소스가 듬뿍 들어간 카라멜 마키아토.', 8),
('진한 그린티 파우더로 만든 말차 라떼.', 9),
('달콤한 딸기 우유 스무디.', 10);

-- ProductImage 더미 데이터
INSERT INTO product_image (url, product_id, is_thumbnail) VALUES
('/images/coffee.png', 1, true),
('https://dummyimage.com/coffee2.jpg', 1, false),
('https://dummyimage.com/cappuccino.jpg', 2, true),
('https://dummyimage.com/vanilla_latte.jpg', 3, true),
('https://dummyimage.com/iced_tea.jpg', 4, true),
('https://dummyimage.com/hotchoco.jpg', 5, true),
('https://dummyimage.com/iced_americano.jpg', 6, true),
('https://dummyimage.com/camomile.jpg', 7, true),
('https://dummyimage.com/caramel.jpg', 8, true),
('https://dummyimage.com/matcha.jpg', 9, true);
