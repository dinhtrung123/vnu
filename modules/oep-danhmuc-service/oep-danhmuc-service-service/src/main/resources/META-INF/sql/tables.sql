create table data_group (
	id LONG not null primary key,
	ma VARCHAR(75) null,
	ten VARCHAR(75) null,
	mota VARCHAR(75) null
);

create table data_item (
	id LONG not null primary key,
	nhom_id LONG,
	ma VARCHAR(75) null,
	TEN VARCHAR(75) null,
	mota VARCHAR(75) null,
	muc INTEGER,
	cha_id LONG,
	thutu_hienthi INTEGER,
	ma_giapha VARCHAR(75) null,
	trangthai BOOLEAN
);