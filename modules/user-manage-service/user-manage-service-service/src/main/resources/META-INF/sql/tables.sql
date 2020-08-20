create table account_log (
	id LONG not null primary key,
	account_id LONG,
	nguoisua_id LONG,
	ten_nguoisua VARCHAR(75) null,
	ngaysua DATE null,
	email_nguoisua VARCHAR(75) null,
	phienban LONG,
	json VARCHAR(75) null
);

create table idm_dataimport (
	id LONG not null primary key,
	screen_name VARCHAR(75) null,
	first_name VARCHAR(75) null,
	last_name VARCHAR(75) null,
	unit VARCHAR(75) null,
	email_address VARCHAR(75) null,
	phone VARCHAR(75) null,
	job_title VARCHAR(75) null,
	role_name VARCHAR(75) null,
	number_id VARCHAR(75) null,
	has_import VARCHAR(75) null,
	error_message VARCHAR(75) null,
	insert_date DATE null
);

create table ttnd_doituongsudung (
	id LONG not null primary key,
	ma VARCHAR(75) null,
	ten VARCHAR(75) null,
	loai INTEGER,
	mota VARCHAR(75) null
);

create table ttnd_thongtincanbo (
	id LONG not null primary key,
	email_address VARCHAR(75) null,
	username VARCHAR(75) null,
	namerole VARCHAR(75) null,
	noidung VARCHAR(75) null
);

create table ttnd_thongtindangky (
	id LONG not null primary key,
	email_address VARCHAR(75) null,
	username VARCHAR(75) null,
	sogiayto VARCHAR(75) null,
	makichhoat VARCHAR(75) null,
	activetype VARCHAR(75) null,
	doituongsudung_id INTEGER,
	noidung VARCHAR(75) null,
	ngaytao DATE null
);