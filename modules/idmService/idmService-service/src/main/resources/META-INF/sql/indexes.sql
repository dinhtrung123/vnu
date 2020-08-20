create index IX_C941F25C on account (accountStatus);
create index IX_8D8B5539 on account (email[$COLUMN_LENGTH:75$]);
create index IX_2ED09A24 on account (groupId, accountStatus, cityCode[$COLUMN_LENGTH:75$]);
create index IX_F58AC107 on account (groupId, accountStatus, districtCode[$COLUMN_LENGTH:75$]);
create index IX_7BC4C275 on account (groupId, accountStatus, wardCode[$COLUMN_LENGTH:75$]);
create index IX_B5BE260A on account (groupId, fullName[$COLUMN_LENGTH:75$], accountStatus);
create index IX_ADB0F5E5 on account (hoSoId);
create index IX_102DA162 on account (personalId[$COLUMN_LENGTH:75$]);

create index IX_8E38B7F8 on data_group (ma[$COLUMN_LENGTH:75$]);

create index IX_7A711BD on data_item (cha_id, muc, trangthai);
create index IX_35BA552D on data_item (cha_id, ten[$COLUMN_LENGTH:75$]);
create index IX_3BCBE08 on data_item (cha_id, trangthai);
create index IX_EE1BD295 on data_item (ma[$COLUMN_LENGTH:75$], muc);
create index IX_446F23D2 on data_item (ma[$COLUMN_LENGTH:75$], trangthai);
create index IX_2063839D on data_item (muc);
create index IX_D4D5F6CC on data_item (nhom_id, ma[$COLUMN_LENGTH:75$]);
create index IX_11DACD19 on data_item (nhom_id, muc, ma[$COLUMN_LENGTH:75$], trangthai);
create index IX_B6732AA2 on data_item (nhom_id, muc, ten[$COLUMN_LENGTH:75$], trangthai);
create index IX_896953A1 on data_item (nhom_id, muc, trangthai);
create index IX_AA89DDA4 on data_item (nhom_id, trangthai);
create index IX_20BF0B7F on data_item (ten[$COLUMN_LENGTH:75$]);
create index IX_76B3E170 on data_item (thutu_hienthi);

create index IX_1BF502 on idm_Account (accountName[$COLUMN_LENGTH:75$]);
create index IX_49EB9F69 on idm_Account (accountStatus);
create index IX_BAC99F1 on idm_Account (accountType);
create index IX_54655F46 on idm_Account (email[$COLUMN_LENGTH:75$]);
create index IX_549DAFF7 on idm_Account (groupId, accountStatus, cityCode[$COLUMN_LENGTH:75$]);
create index IX_A062B55A on idm_Account (groupId, accountStatus, districtCode[$COLUMN_LENGTH:75$]);
create index IX_A191D848 on idm_Account (groupId, accountStatus, wardCode[$COLUMN_LENGTH:75$]);
create index IX_DB8B3BDD on idm_Account (groupId, fullName[$COLUMN_LENGTH:75$], accountStatus);
create index IX_C2182D78 on idm_Account (hoSoId);
create index IX_A838D775 on idm_Account (personalId[$COLUMN_LENGTH:75$]);
create index IX_221BF2E2 on idm_Account (taxCode[$COLUMN_LENGTH:75$]);
create index IX_60CADAE6 on idm_Account (telNo[$COLUMN_LENGTH:75$]);
create index IX_FB01E380 on idm_Account (userId);

create index IX_B633DF2A on idm_photo (className[$COLUMN_LENGTH:75$], classPK, imageType);
create index IX_4A13C358 on idm_photo (classPK);
create index IX_56446D49 on idm_photo (imageType, classPK);

create index IX_56CB5D61 on idm_workitem (accountId);
create index IX_69CF1311 on idm_workitem (title[$COLUMN_LENGTH:75$]);
create index IX_2FA2C951 on idm_workitem (userId);

create index IX_1004F8FD on photo (className[$COLUMN_LENGTH:75$], classPK, imageType);

create index IX_2BA1772E on workitem (accountId);
create index IX_402C1B5E on workitem (title[$COLUMN_LENGTH:75$]);
create index IX_24E6CAA4 on workitem (userId);