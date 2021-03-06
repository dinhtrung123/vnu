/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package dtt.vn.user.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.model.DataImportModel;
import dtt.vn.user.service.model.DataImportSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DataImport service. Represents a row in the &quot;idm_dataimport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DataImportModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataImportImpl}.
 * </p>
 *
 * @author nhanvienDTT
 * @see DataImportImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DataImportModelImpl
	extends BaseModelImpl<DataImport> implements DataImportModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data import model instance should use the <code>DataImport</code> interface instead.
	 */
	public static final String TABLE_NAME = "idm_dataimport";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"screen_name", Types.VARCHAR},
		{"first_name", Types.VARCHAR}, {"last_name", Types.VARCHAR},
		{"unit", Types.VARCHAR}, {"email_address", Types.VARCHAR},
		{"phone", Types.VARCHAR}, {"job_title", Types.VARCHAR},
		{"role_name", Types.VARCHAR}, {"number_id", Types.VARCHAR},
		{"has_import", Types.VARCHAR}, {"error_message", Types.VARCHAR},
		{"insert_date", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("screen_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("first_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("last_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("unit", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email_address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("job_title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("role_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("number_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("has_import", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("error_message", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("insert_date", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table idm_dataimport (id LONG not null primary key,screen_name VARCHAR(75) null,first_name VARCHAR(75) null,last_name VARCHAR(75) null,unit VARCHAR(75) null,email_address VARCHAR(75) null,phone VARCHAR(75) null,job_title VARCHAR(75) null,role_name VARCHAR(75) null,number_id VARCHAR(75) null,has_import VARCHAR(75) null,error_message VARCHAR(75) null,insert_date DATE null)";

	public static final String TABLE_SQL_DROP = "drop table idm_dataimport";

	public static final String ORDER_BY_JPQL = " ORDER BY dataImport.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY idm_dataimport.id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.dtt.vn.user.service.model.DataImport"),
		false);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.dtt.vn.user.service.model.DataImport"),
		false);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.dtt.vn.user.service.model.DataImport"),
		true);

	public static final long EMAILADDRESS_COLUMN_BITMASK = 1L;

	public static final long HASIMPORT_COLUMN_BITMASK = 2L;

	public static final long LASTNAME_COLUMN_BITMASK = 4L;

	public static final long PHONE_COLUMN_BITMASK = 8L;

	public static final long SCREENNAME_COLUMN_BITMASK = 16L;

	public static final long ID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DataImport toModel(DataImportSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DataImport model = new DataImportImpl();

		model.setId(soapModel.getId());
		model.setScreenName(soapModel.getScreenName());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setUnit(soapModel.getUnit());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setPhone(soapModel.getPhone());
		model.setJobTitle(soapModel.getJobTitle());
		model.setNameRole(soapModel.getNameRole());
		model.setNumberId(soapModel.getNumberId());
		model.setHasImport(soapModel.getHasImport());
		model.setErrorMsg(soapModel.getErrorMsg());
		model.setInsertDate(soapModel.getInsertDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DataImport> toModels(DataImportSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DataImport> models = new ArrayList<DataImport>(soapModels.length);

		for (DataImportSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"lock.expiration.time.dtt.vn.user.service.model.DataImport"));

	public DataImportModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataImport.class;
	}

	@Override
	public String getModelClassName() {
		return DataImport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataImport, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataImport, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataImport, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DataImport)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataImport, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataImport, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataImport)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataImport, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataImport, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DataImport>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DataImport.class.getClassLoader(), DataImport.class,
			ModelWrapper.class);

		try {
			Constructor<DataImport> constructor =
				(Constructor<DataImport>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<DataImport, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataImport, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataImport, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DataImport, Object>>();
		Map<String, BiConsumer<DataImport, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DataImport, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object id) {
					dataImport.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"screenName",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getScreenName();
				}

			});
		attributeSetterBiConsumers.put(
			"screenName",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object screenName) {
					dataImport.setScreenName((String)screenName);
				}

			});
		attributeGetterFunctions.put(
			"firstName",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getFirstName();
				}

			});
		attributeSetterBiConsumers.put(
			"firstName",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object firstName) {
					dataImport.setFirstName((String)firstName);
				}

			});
		attributeGetterFunctions.put(
			"lastName",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getLastName();
				}

			});
		attributeSetterBiConsumers.put(
			"lastName",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object lastName) {
					dataImport.setLastName((String)lastName);
				}

			});
		attributeGetterFunctions.put(
			"unit",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getUnit();
				}

			});
		attributeSetterBiConsumers.put(
			"unit",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object unit) {
					dataImport.setUnit((String)unit);
				}

			});
		attributeGetterFunctions.put(
			"emailAddress",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getEmailAddress();
				}

			});
		attributeSetterBiConsumers.put(
			"emailAddress",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object emailAddress) {
					dataImport.setEmailAddress((String)emailAddress);
				}

			});
		attributeGetterFunctions.put(
			"phone",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getPhone();
				}

			});
		attributeSetterBiConsumers.put(
			"phone",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object phone) {
					dataImport.setPhone((String)phone);
				}

			});
		attributeGetterFunctions.put(
			"jobTitle",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getJobTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"jobTitle",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object jobTitle) {
					dataImport.setJobTitle((String)jobTitle);
				}

			});
		attributeGetterFunctions.put(
			"nameRole",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getNameRole();
				}

			});
		attributeSetterBiConsumers.put(
			"nameRole",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object nameRole) {
					dataImport.setNameRole((String)nameRole);
				}

			});
		attributeGetterFunctions.put(
			"numberId",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getNumberId();
				}

			});
		attributeSetterBiConsumers.put(
			"numberId",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object numberId) {
					dataImport.setNumberId((String)numberId);
				}

			});
		attributeGetterFunctions.put(
			"hasImport",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getHasImport();
				}

			});
		attributeSetterBiConsumers.put(
			"hasImport",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object hasImport) {
					dataImport.setHasImport((String)hasImport);
				}

			});
		attributeGetterFunctions.put(
			"errorMsg",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getErrorMsg();
				}

			});
		attributeSetterBiConsumers.put(
			"errorMsg",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object errorMsg) {
					dataImport.setErrorMsg((String)errorMsg);
				}

			});
		attributeGetterFunctions.put(
			"insertDate",
			new Function<DataImport, Object>() {

				@Override
				public Object apply(DataImport dataImport) {
					return dataImport.getInsertDate();
				}

			});
		attributeSetterBiConsumers.put(
			"insertDate",
			new BiConsumer<DataImport, Object>() {

				@Override
				public void accept(DataImport dataImport, Object insertDate) {
					dataImport.setInsertDate((Date)insertDate);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public String getScreenName() {
		if (_screenName == null) {
			return "";
		}
		else {
			return _screenName;
		}
	}

	@Override
	public void setScreenName(String screenName) {
		_columnBitmask |= SCREENNAME_COLUMN_BITMASK;

		if (_originalScreenName == null) {
			_originalScreenName = _screenName;
		}

		_screenName = screenName;
	}

	public String getOriginalScreenName() {
		return GetterUtil.getString(_originalScreenName);
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_columnBitmask |= LASTNAME_COLUMN_BITMASK;

		if (_originalLastName == null) {
			_originalLastName = _lastName;
		}

		_lastName = lastName;
	}

	public String getOriginalLastName() {
		return GetterUtil.getString(_originalLastName);
	}

	@JSON
	@Override
	public String getUnit() {
		if (_unit == null) {
			return "";
		}
		else {
			return _unit;
		}
	}

	@Override
	public void setUnit(String unit) {
		_unit = unit;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return "";
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_columnBitmask |= EMAILADDRESS_COLUMN_BITMASK;

		if (_originalEmailAddress == null) {
			_originalEmailAddress = _emailAddress;
		}

		_emailAddress = emailAddress;
	}

	public String getOriginalEmailAddress() {
		return GetterUtil.getString(_originalEmailAddress);
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return "";
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		_columnBitmask |= PHONE_COLUMN_BITMASK;

		if (_originalPhone == null) {
			_originalPhone = _phone;
		}

		_phone = phone;
	}

	public String getOriginalPhone() {
		return GetterUtil.getString(_originalPhone);
	}

	@JSON
	@Override
	public String getJobTitle() {
		if (_jobTitle == null) {
			return "";
		}
		else {
			return _jobTitle;
		}
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	@JSON
	@Override
	public String getNameRole() {
		if (_nameRole == null) {
			return "";
		}
		else {
			return _nameRole;
		}
	}

	@Override
	public void setNameRole(String nameRole) {
		_nameRole = nameRole;
	}

	@JSON
	@Override
	public String getNumberId() {
		if (_numberId == null) {
			return "";
		}
		else {
			return _numberId;
		}
	}

	@Override
	public void setNumberId(String numberId) {
		_numberId = numberId;
	}

	@JSON
	@Override
	public String getHasImport() {
		if (_hasImport == null) {
			return "";
		}
		else {
			return _hasImport;
		}
	}

	@Override
	public void setHasImport(String hasImport) {
		_columnBitmask |= HASIMPORT_COLUMN_BITMASK;

		if (_originalHasImport == null) {
			_originalHasImport = _hasImport;
		}

		_hasImport = hasImport;
	}

	public String getOriginalHasImport() {
		return GetterUtil.getString(_originalHasImport);
	}

	@JSON
	@Override
	public String getErrorMsg() {
		if (_errorMsg == null) {
			return "";
		}
		else {
			return _errorMsg;
		}
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		_errorMsg = errorMsg;
	}

	@JSON
	@Override
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, DataImport.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataImport toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataImportImpl dataImportImpl = new DataImportImpl();

		dataImportImpl.setId(getId());
		dataImportImpl.setScreenName(getScreenName());
		dataImportImpl.setFirstName(getFirstName());
		dataImportImpl.setLastName(getLastName());
		dataImportImpl.setUnit(getUnit());
		dataImportImpl.setEmailAddress(getEmailAddress());
		dataImportImpl.setPhone(getPhone());
		dataImportImpl.setJobTitle(getJobTitle());
		dataImportImpl.setNameRole(getNameRole());
		dataImportImpl.setNumberId(getNumberId());
		dataImportImpl.setHasImport(getHasImport());
		dataImportImpl.setErrorMsg(getErrorMsg());
		dataImportImpl.setInsertDate(getInsertDate());

		dataImportImpl.resetOriginalValues();

		return dataImportImpl;
	}

	@Override
	public int compareTo(DataImport dataImport) {
		long primaryKey = dataImport.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataImport)) {
			return false;
		}

		DataImport dataImport = (DataImport)obj;

		long primaryKey = dataImport.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DataImportModelImpl dataImportModelImpl = this;

		dataImportModelImpl._originalScreenName =
			dataImportModelImpl._screenName;

		dataImportModelImpl._originalLastName = dataImportModelImpl._lastName;

		dataImportModelImpl._originalEmailAddress =
			dataImportModelImpl._emailAddress;

		dataImportModelImpl._originalPhone = dataImportModelImpl._phone;

		dataImportModelImpl._originalHasImport = dataImportModelImpl._hasImport;

		dataImportModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DataImport> toCacheModel() {
		DataImportCacheModel dataImportCacheModel = new DataImportCacheModel();

		dataImportCacheModel.id = getId();

		dataImportCacheModel.screenName = getScreenName();

		String screenName = dataImportCacheModel.screenName;

		if ((screenName != null) && (screenName.length() == 0)) {
			dataImportCacheModel.screenName = null;
		}

		dataImportCacheModel.firstName = getFirstName();

		String firstName = dataImportCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			dataImportCacheModel.firstName = null;
		}

		dataImportCacheModel.lastName = getLastName();

		String lastName = dataImportCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			dataImportCacheModel.lastName = null;
		}

		dataImportCacheModel.unit = getUnit();

		String unit = dataImportCacheModel.unit;

		if ((unit != null) && (unit.length() == 0)) {
			dataImportCacheModel.unit = null;
		}

		dataImportCacheModel.emailAddress = getEmailAddress();

		String emailAddress = dataImportCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			dataImportCacheModel.emailAddress = null;
		}

		dataImportCacheModel.phone = getPhone();

		String phone = dataImportCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			dataImportCacheModel.phone = null;
		}

		dataImportCacheModel.jobTitle = getJobTitle();

		String jobTitle = dataImportCacheModel.jobTitle;

		if ((jobTitle != null) && (jobTitle.length() == 0)) {
			dataImportCacheModel.jobTitle = null;
		}

		dataImportCacheModel.nameRole = getNameRole();

		String nameRole = dataImportCacheModel.nameRole;

		if ((nameRole != null) && (nameRole.length() == 0)) {
			dataImportCacheModel.nameRole = null;
		}

		dataImportCacheModel.numberId = getNumberId();

		String numberId = dataImportCacheModel.numberId;

		if ((numberId != null) && (numberId.length() == 0)) {
			dataImportCacheModel.numberId = null;
		}

		dataImportCacheModel.hasImport = getHasImport();

		String hasImport = dataImportCacheModel.hasImport;

		if ((hasImport != null) && (hasImport.length() == 0)) {
			dataImportCacheModel.hasImport = null;
		}

		dataImportCacheModel.errorMsg = getErrorMsg();

		String errorMsg = dataImportCacheModel.errorMsg;

		if ((errorMsg != null) && (errorMsg.length() == 0)) {
			dataImportCacheModel.errorMsg = null;
		}

		Date insertDate = getInsertDate();

		if (insertDate != null) {
			dataImportCacheModel.insertDate = insertDate.getTime();
		}
		else {
			dataImportCacheModel.insertDate = Long.MIN_VALUE;
		}

		return dataImportCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataImport, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataImport, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataImport, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DataImport)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DataImport, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataImport, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataImport, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DataImport)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, DataImport>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _id;
	private String _screenName;
	private String _originalScreenName;
	private String _firstName;
	private String _lastName;
	private String _originalLastName;
	private String _unit;
	private String _emailAddress;
	private String _originalEmailAddress;
	private String _phone;
	private String _originalPhone;
	private String _jobTitle;
	private String _nameRole;
	private String _numberId;
	private String _hasImport;
	private String _originalHasImport;
	private String _errorMsg;
	private Date _insertDate;
	private long _columnBitmask;
	private DataImport _escapedModel;

}