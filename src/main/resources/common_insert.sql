#########################################
INSERT INTO codegroup (group_id, group_name)
VALUES ('1', '주거지역');
INSERT INTO codegroup (group_id, group_name)
VALUES ('2', '상업지역');
INSERT INTO codegroup (group_id, group_name)
VALUES ('3', '공업지역');
INSERT INTO codegroup (group_id, group_name)
VALUES ('4', '녹지지역');

#########################################
############# 1 도시지역 
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('101', '전용주거지역', '1');
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('102', '일반주거지역', '1');
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('103', '준주거지역', '1');

############# 2 상업지역 
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('201', '중심상업지역', '2');
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('202', '일반상업지역', '2');
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('203', '근린상업지역', '2');
INSERT INTO codegroup (group_id, group_name, parent_group_id)
VALUES ('204', '유통상업지역', '2');
##########################################


INSERT INTO code (code_id, code_name, group_id)
VALUES ('01', '제1종', '101');
INSERT INTO code (code_id, code_name, group_id)
VALUES ('02', '제2종', '101');

INSERT INTO code (code_id, code_name, group_id)
VALUES ('01', '제1종', '102');
INSERT INTO code (code_id, code_name, group_id)
VALUES ('02', '제2종', '102');
INSERT INTO code (code_id, code_name, group_id)
VALUES ('03', '제3종', '102');


SELECT * from code c 
join codegroup cg 
on c.group_id =cg.group_id 
WHERE cg.group_id ='102';

