

insert into product (name,price,stock_quantity) values ('아이폰 17 무료 완전 무료',10000,23);
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
