create table idm_mappingvmap (
	id LONG not null primary key,
	classpk LONG,
	classname VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	ghichu VARCHAR(75) null
);

create table idm_phanquyen (
	id LONG not null primary key,
	classname VARCHAR(75) null,
	classpk LONG,
	giatri VARCHAR(75) null
);

create table idm_trungtamhanhchinh (
	id LONG not null primary key,
	ma VARCHAR(75) null,
	ten VARCHAR(75) null,
	donvi_id LONG,
	donvi_ids VARCHAR(75) null,
	thongtin_lienhe VARCHAR(75) null,
	trangthai INTEGER
);

create table oep_logs_sms (
	id LONG not null primary key,
	sent_date_time DATE null,
	phone VARCHAR(75) null,
	response_date DATE null,
	error_code VARCHAR(75) null,
	error_detail VARCHAR(75) null,
	message_id LONG
);

create table oep_mail_history (
	id LONG not null primary key,
	group_id LONG,
	ma VARCHAR(75) null,
	to_address VARCHAR(75) null,
	subject VARCHAR(75) null,
	body VARCHAR(75) null,
	ngaygui DATE null,
	trangthai BOOLEAN
);

create table oep_thamso (
	id LONG not null primary key,
	group_id LONG,
	classname VARCHAR(75) null,
	classpk LONG,
	loai_id LONG,
	ma VARCHAR(75) null,
	giatri VARCHAR(75) null,
	mota VARCHAR(75) null,
	trangthai BOOLEAN,
	quyen_tac_dong INTEGER
);

create table oep_thamso_loai (
	id LONG not null primary key,
	ma VARCHAR(75) null,
	ten VARCHAR(75) null,
	mota VARCHAR(75) null
);