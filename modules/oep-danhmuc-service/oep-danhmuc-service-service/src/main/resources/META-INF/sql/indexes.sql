create index IX_8E38B7F8 on data_group (ma[$COLUMN_LENGTH:75$]);

create index IX_1EED175F on data_item (TEN[$COLUMN_LENGTH:75$]);
create index IX_33E8610D on data_item (cha_id, TEN[$COLUMN_LENGTH:75$]);
create index IX_7A711BD on data_item (cha_id, muc, trangthai);
create index IX_3BCBE08 on data_item (cha_id, trangthai);
create index IX_EE1BD295 on data_item (ma[$COLUMN_LENGTH:75$], muc);
create index IX_446F23D2 on data_item (ma[$COLUMN_LENGTH:75$], trangthai);
create index IX_2063839D on data_item (muc);
create index IX_D4D5F6CC on data_item (nhom_id, ma[$COLUMN_LENGTH:75$]);
create index IX_D10F2C2 on data_item (nhom_id, muc, TEN[$COLUMN_LENGTH:75$], trangthai);
create index IX_11DACD19 on data_item (nhom_id, muc, ma[$COLUMN_LENGTH:75$], trangthai);
create index IX_896953A1 on data_item (nhom_id, muc, trangthai);
create index IX_AA89DDA4 on data_item (nhom_id, trangthai);
create index IX_76B3E170 on data_item (thutu_hienthi);