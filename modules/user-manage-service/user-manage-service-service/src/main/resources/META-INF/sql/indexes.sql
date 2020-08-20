create index IX_BB46B119 on account_log (account_id);

create index IX_BABF423F on idm_dataimport (email_address[$COLUMN_LENGTH:75$]);
create index IX_B3D2F620 on idm_dataimport (has_import[$COLUMN_LENGTH:75$]);
create index IX_6BA1B7C2 on idm_dataimport (last_name[$COLUMN_LENGTH:75$]);
create index IX_78FAB61C on idm_dataimport (phone[$COLUMN_LENGTH:75$]);
create index IX_CB431E2C on idm_dataimport (screen_name[$COLUMN_LENGTH:75$]);

create index IX_ED4E70EC on ttnd_doituongsudung (ma[$COLUMN_LENGTH:75$]);

create index IX_C910ABCC on ttnd_thongtincanbo (email_address[$COLUMN_LENGTH:75$]);
create index IX_156F304A on ttnd_thongtincanbo (namerole[$COLUMN_LENGTH:75$]);
create index IX_99507A5F on ttnd_thongtincanbo (username[$COLUMN_LENGTH:75$]);

create index IX_D42FFEC on ttnd_thongtindangky (activetype[$COLUMN_LENGTH:75$]);
create index IX_5BCA4D89 on ttnd_thongtindangky (email_address[$COLUMN_LENGTH:75$]);
create index IX_7D27123D on ttnd_thongtindangky (makichhoat[$COLUMN_LENGTH:75$]);
create index IX_C08A24DD on ttnd_thongtindangky (sogiayto[$COLUMN_LENGTH:75$]);
create index IX_1B5DF682 on ttnd_thongtindangky (username[$COLUMN_LENGTH:75$]);