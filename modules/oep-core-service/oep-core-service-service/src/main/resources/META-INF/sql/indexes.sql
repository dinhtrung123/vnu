create index IX_36B390BD on idm_mappingvmap (classname[$COLUMN_LENGTH:75$], classpk);
create index IX_BE4CA796 on idm_mappingvmap (classpk);

create index IX_BD5A9A02 on idm_phanquyen (classname[$COLUMN_LENGTH:75$], classpk);

create index IX_1B4B6E8C on idm_trungtamhanhchinh (donvi_id);
create index IX_F32AA1DC on idm_trungtamhanhchinh (ma[$COLUMN_LENGTH:75$]);

create index IX_3E4B7107 on oep_thamso (giatri[$COLUMN_LENGTH:75$]);
create index IX_9AABEE5E on oep_thamso (group_id, ma[$COLUMN_LENGTH:75$]);
create index IX_CACDC45F on oep_thamso (ma[$COLUMN_LENGTH:75$], classname[$COLUMN_LENGTH:75$], classpk);

create index IX_B0C0EEFE on oep_thamso_loai (ten[$COLUMN_LENGTH:75$]);