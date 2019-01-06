SET DEFINE OFF;

/*----User-----*/
Insert into USERS (NAME,EMAIL,PASSWORD,ROLE_ID,ADDRESS,PHONE,BIRTHDAY) values ('Admin','admin@gmail.com','1Aa@',1,'14 Five Ave','631-555-2222',null);
Insert into USERS (NAME,EMAIL,PASSWORD,ROLE_ID,ADDRESS,PHONE,BIRTHDAY) values ('Moderator','moderator@gmail.com','2Aa@',2,null,null,null);
Insert into USERS (NAME,EMAIL,PASSWORD,ROLE_ID,ADDRESS,PHONE,BIRTHDAY) values ('Cristina White','cristina@gmail.com','3Aa@',3,null,null,null);
Insert into USERS (NAME,EMAIL,PASSWORD,ROLE_ID,ADDRESS,PHONE,BIRTHDAY) values ('Ben Smith','ben@gmail.com','4Aa@',3,'214 Ocean Street','515-515-5555',null);
Insert into USERS (NAME,EMAIL,PASSWORD,ROLE_ID,ADDRESS,PHONE,BIRTHDAY) values ('Amy Star','amy@gmail.com','5Aa@',3,null,null,null);

/*-----Brand-------*/
Insert into BRAND (NAME,DESCRIPTION) values ('Banna','Banna');
Insert into BRAND (NAME,DESCRIPTION) values ('Isme','Isme');
Insert into BRAND (NAME,DESCRIPTION) values ('Mistine','Mistine');
Insert into BRAND (NAME,DESCRIPTION) values ('Carebeau','Carebeau');
Insert into BRAND (NAME,DESCRIPTION) values ('BMB','BMB');
Insert into BRAND (NAME,DESCRIPTION) values ('Nature Republic','Nature Republic');
Insert into BRAND (NAME,DESCRIPTION) values ('Fara','Fara');

/*------Group--------*/
Insert into GROUPS (NAME,DESCRIPTION) values ('Sale','Sale');
Insert into GROUPS (NAME,DESCRIPTION) values ('SkinCare','ScinCare');
Insert into GROUPS (NAME,DESCRIPTION) values ('Hair','Hair');
Insert into GROUPS (NAME,DESCRIPTION) values ('Bath&Body','Bath&Body');
Insert into GROUPS (NAME,DESCRIPTION) values ('MakeUp','MakeUp');

/*------Category----------*/
Insert into CATEGORY (NAME,DESCRIPTION) values ('Sale','Sale');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Masks','Masks');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Lip Treatments','Lip Treatments');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Cleansers','Cleansers');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Moisturizers','Moisturizers');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Shampoo&Conditioner','Shampoo&Conditioner');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Treatments','Treatments');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Body Moisturizers','Body Moisturizers');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Body Care','Body Care');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Face','Face');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Lip','Lip');
Insert into CATEGORY (NAME,DESCRIPTION) values ('Eye','Eye');

/*-------Group_Category---------*/
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (51,102);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (52,103);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (52,104);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (52,105);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (52,106);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (53,107);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (53,108);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (54,109);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (54,110);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (55,111);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (55,112);
Insert into GROUP_CATEGORY (GROUP_ID,CATEGORY_ID) values (55,113);

/*-------Product---------*/
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Coconut oil',201,'coconut_oil.jpg','Coconut oil');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Cream Crocco',201,'cream_crocco.jpg','Cream Crocco');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Cream for foot & hand',206,'cream_foot_hand.jpg','Cream for foot & hand');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Collagen Crystal Eyelid Patch',201,'eyelid_patch.jpg','Collagen Crystal Eyelid Patch');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Facial Foam',204,'facial_foam_papaya_mistine.jpg','Facial Foam');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Hair Balm',202,'hair_balm_papaya.jpg','Hair balm');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Hair Mask',205,'hair_cond_coconut.jpg','Hair Mask');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Shampoo&Conditioner',202,'hair_shampoo_cond.jpg','Shampoo&Conditioner');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Hair Vitamin Mask',201,'hair_vitamin_wax.jpg','Hair Vitamin Mask');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Hair Vitamin Capsules',201,'hair_vitamins1.jpg','Hair Vitamin Capsules');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Shape Firming Herbal Cream',203,'hot_cream_shape.jpg','Shape Firming Herbal Cream');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Lip Balm',201,'lip_balm_coconut.jpg','Lip Balm');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Lip Balm',201,'lip_balm_passion_5g.jpg','Lip Balm');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Pearl Cream',207,'pearl_cream_NR.jpg','Parl Cream');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Scalp Treatment',201,'scalp_treatment.jpg','Scalp Treatment');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Aloe Vera Gel',201,'skin_gel_aloe_vera.jpg','Aloe Vera Gel');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Spa Soap',208,'soap_handmade.jpg','Spa Soap Handmade');
Insert into PRODUCT (NAME,BRAND_ID,IMAGE_SOURCE,DESCRIPTION) values ('Body Cream',202,'body_cream_pineapple.jpg','Body Cream');

/*-------Category_Product---------*/
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100001,101);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100001,106);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100002,106);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100003,109);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100004,103);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100005,105);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100006,101);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100006,102);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100006,107);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100006,108);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100007,102);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100007,107);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100007,108);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100008,107);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100009,108);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100010,108);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100011,110);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100012,101);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100012,104);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100012,112);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100013,104);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100013,112);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100014,111);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100015,108);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100016,102);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100016,110);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100017,101);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100017,105);
Insert into CATEGORY_PRODUCT (PRODUCT_ID,CATEGORY_ID) values (100018,109);

/*-----Item-------*/
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100001,15,'Coconut','50 ml',11,150,0,'coconut_oil.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100002,31,'no','50 ml',11,50,0,'cream_crocco.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100003,9,'no','100 ml',11,100,0,'cream_foot_hand.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100004,7.5,'no','2 it',11,100,0,'eyelid_patch.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100005,6.99,'Papaya','75 ml',11,100,0,'facial_foam_papaya_mistine.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100006,16.5,'Papaya','200 ml',11,80,0,'hair_balm_papaya.jpg',10,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100006,16.5,'Banana','200 ml',11,75,0,'hair_balm_banana.jpg',10,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100006,18,'Mangostin','200 ml',11,60,0,'hair_balm_mangostin.jpg',10,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100006,16.5,'Olive','200 ml',11,90,0,'hair_balm_olive.jpg',10,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100007,21.8,'Coconut','200 ml',11,160,0,'Hair_cond_coconut.jpg',15,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100008,22,'Pineapple','150 ml',11,50,0,'hair_shampoo_cond.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100009,4.99,'no','75 ml',11,75,0,'hair_vitamin_wax.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100010,0.25,'no','5 ml',11,1000,0,'hair_vitamins1.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100011,16.99,'no','50 ml',11,75,0,'hot_cream_shape.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100012,4,'Coconut','5 g',11,200,0,'lip_balm_coconut.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100012,4,'Peach','5 g',11,60,0,'lip_balm_coconut.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100012,4,'Orange','5 g',11,150,0,'lip_balm_coconut.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100013,5,'Passion fruit','4.5 g',11,250,0,'lip_balm_passion_5g.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100013,5,'Passion fruit','4.5 g',11,10,0,'lip_balm_passion_5g.jpg',0,0);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100013,5,'Passion fruit','4.5 g',11,100,0,'lip_balm_passion_5g.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100014,15,'not','50 ml',11,90,0,'pearl_cream_NR.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100015,11.6,'not','75 ml',11,80,0,'scalp_treatment.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100016,8.99,'n/t','75 ml',11,75,0,'skin_gel_aloe_vera.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100017,4.5,'Banana','200 g',11,250,0,'soap_handmade.jpg',25,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100017,4.5,'Coconut','200 g',11,100,0,'soap_handmade.jpg',25,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100017,4.5,'Passion fruit','200 g',11,45,0,'soap_handmade.jpg',25,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100017,4.5,'Pineapple','200 g',11,260,0,'soap_handmade.jpg',25,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100017,4.5,'Lemon','200 g',11,175,0,'soap_handmade.jpg',25,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100018,11.5,'Pineapple','500 ml',11,150,0,'body_cream_pineapple.jpg',0,1);
Insert into ITEM (PRODUCT_ID,PRICE,ITEM_TYPE,ITEM_SIZE,CURRENCY_ID,QUANTITY,QUANT_ORDERED,IMAGE_SOURCE,DISCOUNT,AVAILABLE) values (100018,14,'Chocolate','500 ml',11,140,0,'body_cream_chocolate.jpg',0,1);