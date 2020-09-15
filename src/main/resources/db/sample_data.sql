--- ONLINE_ATTENDANCES
---  id | platforms | whats_app_number
--- ----+-----------+------------------
INSERT INTO online_attendances
VALUES
    (1, 'Zoom, Google Hangouts', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (2, null, '(81) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (3, 'Google Meets, Skype, Zoom', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (4, 'Skype', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (5, 'Zoom, Skype', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (6, 'Google Hangouts, Google Meets', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (7, 'Skype', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (8, 'Skype', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (9, 'Zoom', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (10, null, '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (11, 'Google Hangouts, Skype', '(11) 99999-9999')
ON conflict do nothing;

INSERT INTO online_attendances
VALUES
    (12, 'Zoom', '(11) 99999-9999')
ON conflict do nothing;



--- HOUSEHOLD_ATTEANDANCES
--- id | state | city | email
--- ---+-------+------+-------
INSERT INTO household_attendances
VALUES
    (1, 'São Paulo', 'São Paulo', 'household_1@email.com')
ON conflict do nothing;

INSERT INTO household_attendances
VALUES
    (2, 'São Paulo', 'São Paulo', 'household_2@email.com')
ON conflict do nothing;

INSERT INTO household_attendances
VALUES
    (3, 'São Paulo', 'São Paulo', 'household_3@email.com')
ON conflict do nothing;

INSERT INTO household_attendances
VALUES
    (4, 'Pernambuco', 'Recife', 'household_4@email.com')
ON conflict do nothing;



--- HOSPITAL_CLINIC_ATTENDANCES
--- id | state | state_initials | city | street_name | street_number | complement_info | name | phone | email | cep
----+-------+----------------+------+-------------+---------------+-----------------+------+-------+-------+-----
INSERT INTO hospital_clinic_attendances
VALUES
    (1, 'São Paulo', 'SP', 'São Paulo', 'Av. Paulista', 200, null, 'Hospital Santa Catarina', '(11) 99999-9999', 'hospital_sc@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (2, 'São Paulo', 'SP', 'São Paulo', 'Av. Paulista', 200, null, 'Hospital Santa Catarina', '(11) 99999-9999', 'hospital_sc@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (3, 'São Paulo', 'SP', 'São Paulo', 'Rua Pedro de Toledo', 910, null, 'Hospital São Paulo', '(11) 99999-9999', 'hospital_sp@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (4, 'Santa Catarina', 'SC', 'Blumenau', 'R. Amazonas', 301, null, 'Hospital Santa Catarina de Blumenau', '(47) 99999-9999', 'hospital_sc_blu@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (5, 'Pernambuco', 'PE', 'Recife', 'R. Joaquim Nabuco', 200, null, 'Hospital Santa Joana Recife', '(81) 99999-9999', 'hospital_pe@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (6, 'Pernambuco', 'PE', 'Recife', 'R. Joaquim Nabuco', 200, null, 'Hospital da Mulher do Recife', '(81) 99999-9999', 'hospital_pe_mulher@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (7, 'Pernambuco', 'PE', 'Recife', 'R. Joaquim Nabuco', 200, null, 'Santa Casa da Misericórdia do Recife', '(81) 99999-9999', 'hospital_pe_misericordia@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (8, 'Rio Grande do Sul', 'RS', 'Porto Alegre', 'R. Antônio Francisco da Rocha', 100, null, 'Hospital Porto Alegre', '(51) 99999-9999', 'hospital_rs@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (9, 'Rio Grande do Sul', 'RS', 'Porto Alegre', 'R. Antônio Francisco da Rocha', 100, null, 'Hospital Independência', '(51) 99999-9999', 'hospital_rs_independencia@email.com', '00000-000')
ON conflict do nothing;

INSERT INTO hospital_clinic_attendances
VALUES
    (10, 'Rio Grande do Sul', 'RS', 'Porto Alegre', 'R. Antônio Francisco da Rocha', 100, null, 'Hospital Parque Belém', '(51) 99999-9999', 'hospital_rs_belem@email.com', '00000-000')
ON conflict do nothing;



--- ATTENDANCES
--- id | hospital_clinic_attendance_id | household_attendance_id | online_attendance_id
--- ---+-------------------------------+-------------------------+----------------------
insert into attendances
VALUES
    (1, 1, 1, 1)
on conflict do nothing;

insert into attendances
VALUES
    (2, 2, 2, 2)
on conflict do nothing;

insert into attendances
VALUES
    (3, 3, 3, 3)
on conflict do nothing;

insert into attendances
VALUES
    (4, 4, null, 4)
on conflict do nothing;

insert into attendances
VALUES
    (5, 5, null, 5)
on conflict do nothing;

insert into attendances
VALUES
    (6, 6, null, 6)
on conflict do nothing;

insert into attendances
VALUES
    (7, 7, null, 7)
on conflict do nothing;

insert into attendances
VALUES
    (8, 8, null, 8)
on conflict do nothing;

insert into attendances
VALUES
    (9, 9, null, null)
on conflict do nothing;

insert into attendances
VALUES
    (10, 10, null, null)
on conflict do nothing;

insert into attendances
VALUES
    (11, null, 4, null)
on conflict do nothing;

insert into attendances
VALUES
    (12, null, null, 9)
on conflict do nothing;

insert into attendances
VALUES
    (13, null, null, 10)
on conflict do nothing;

insert into attendances
VALUES
    (14, null, null, 11)
on conflict do nothing;

insert into attendances
VALUES
    (15, null, null, 12)
on conflict do nothing;


--- PROFESSIONALS
--- id | name | biography | category | specialty | register_number | health_insurance | is_referred | terms_and_conditions | admin_approved | email | phone | attendance_id
--- --+------+-----------+----------+------------+-----------------+------------------+-------------+----------------------+----------------+-------+-------+---------------

insert into professionals
values
    (1, 'Marco Beduschi', 'As aventuras de um excêntrico alien viajando através do espaço-tempo com seus companheiros. O Doctor é um Senhor do Tempo renegado: excêntrico, inteligentíssimo, ele fugiu de seu planeta de origem, Gallifrey, em uma curiosa nave espacial chamada TARDIS, que é maior por dentro que por fora.', 3, 'Doctor Who', 'crp-xxxx', null, false, true, true, 'user1@email.com', '(47) 99999-9999', 1)
on conflict do nothing;

insert into professionals
values
    (2, 'Amilton Baracy Junior', 'Enfermeiro especializado em libras', 0, null, 'crp-xxxx', null, true, true, true, 'user2@email.com', '(51) 99999-9999', 2)
on conflict do nothing;

insert into professionals
values
    (3, 'Felipe Fahrion', 'Neurocirurgião com 20 anos de Carreira. Whatsapp: (51) 99999-9999', 3, 'Neurocirurgião', 'crp-xxxx', null, false, true, true, 'user3@email.com', '(51) 99999-9999', 3)
on conflict do nothing;

insert into professionals
values
    (4, 'Manuella Toerrao', 'Surda, deva, mãe, minimalista, apaixonada por aventuras off road e paisagens exuberantes. Ama cozinhar e comer. Militante pela garantia do direito a acessibilidade para a comunidade surda de forma humanizada e uso de língua de sinais.', 6, 'Psicoterapia & Sonoterapia', 'crp-xxxx', null, false, true, true, 'user4@email.com', '(81) 99999-9999', 4)
on conflict do nothing;

insert into professionals
values
    (5, 'Beatriz Lonskis', 'Surda, designer, mãe e integrante de família surda. Ama ler livros, cozinhar, viajar. Busca incansavelmente as soluções que possibilitem maior autonomia para as pessoas surdas, quebrando barreiras de comunicação.', 2, 'Fonoaudiologia Educacional', 'crp-xxxx', null, false, true, true, 'user5@email.com', '(11) 99999-9999', 5)
on conflict do nothing;

insert into professionals
values
    (6, 'Cris Brand', 'Enfermeira especializada em libras', 0, 'Enfermagem em UTI', 'crp-xxxx', null, false, true, true, 'user6@email.com', '(51) 99999-9999', 6)
on conflict do nothing;

insert into professionals
values
    (7, 'Matheus Viana', 'Fisioterapeuta com 11 anos de conhecimento em fisioterapia aquática para profissionais da natação.', 1, 'Fisioterapia Aquática', 'crp-xxxx', null, false, true, true, 'user7@email.com', '(81) 99999-9999', 7)
on conflict do nothing;

insert into professionals
values
    (8, 'Ramon Costa', 'Coach Quântico de Médicos & Enfermeiras especializado em Libras! Mude seu mindset!', 7, 'Coach Quântico Médico', 'crp-xxxx', null, false, true, true, 'user8@email.com', '(51) 99999-9999', 8)
on conflict do nothing;

insert into professionals
values
    (9, 'Laura Melo', 'Cardiologista com 15 anos de experiência na área. Se formou com apenas 10 anos de idade na faculdade de medicina. Uma verdadeira prodígia.', 3, 'Cardiologista', 'crp-xxxx', null, false, true, true, 'user9@email.com', '(51) 99999-9999', 9)
on conflict do nothing;

insert into professionals
values
    (10, 'Guilherme Vandresen', 'Anestesiologia. Ama seus 12 filhos, 27 gatos, 3 cachorros e 1 cabra. Também adora ver a tinta da parece cecar, comigo não tem stress!', 3, 'Anestesiologista', 'crp-xxxx', null, false, true, true, 'user10@email.com', '(51) 99999-9999', 10)
on conflict do nothing;

insert into professionals
values
    (11, 'Inessa Luerce', 'Cirurgiã Plástica, ama tricotar, andar de skate e ouvir música clássica, tudo junto.', 3, 'Cirugiã Plástica', 'crp-xxxx', null, false, true, true, 'user11@email.com', '(51) 99999-9999', 11)
on conflict do nothing;

insert into professionals
values
    (12, 'Andressa Silva', 'Geriatra. Adora jogar rugby com as pessoas da melhor idade. Jura que não pega leve com nenhum deles!', 3, 'Geriartra', 'crp-xxxx', null, false, true, true, 'user12@email.com', '(51) 99999-9999', 12)
on conflict do nothing;

insert into professionals
values
    (13, 'João Alcantara', 'Médico Núclear. Só Deus sabe o que isso significa, mas aparentemente é uma especialidade legítica da medicina.', 3, 'Médico Núclear', 'crp-xxxx', null, false, true, true, 'user13@email.com', '(51)99999-9999', 13)
on conflict do nothing;

insert into professionals
values
    (14, 'Marcos Bezerra', 'Circurgião Vascular. Após 35 anos de carreira e longas sessões de meditação eu transcendi e hoje sou capaz de operar um paciente telepaticamente.', 3, 'Cirurgião Vascular', 'crp-xxxx', null, false, true, true, 'user14@email.com', '(51) 99999-9999', 14)
on conflict do nothing;

insert into professionals
values
    (15, 'Luana Gayer', 'Pediatra especializada em atender criaças super poderosas. Em meus anos de experiência atendi crianças famosas como as meninas super poderosas, o garoto de Esqueceram de Mim e a menina do filme Grinch.', 3, 'Pediatra', 'crp-xxxx', null, false, true, true, 'user15@email.com', '(51) 99999-9999', 15)
on conflict do nothing;

