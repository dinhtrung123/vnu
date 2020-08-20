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
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.user.service.model.AccountLog;
import dtt.vn.user.service.model.AccountLogModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AccountLog service. Represents a row in the &quot;account_log&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AccountLogModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AccountLogImpl}.
 * </p>
 *
 * @author nhanvienDTT
 * @see AccountLogImpl
 * @generated
 */
@ProviderType
public class AccountLogModelImpl
	extends BaseModelImpl<AccountLog> implements AccountLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a account log model instance should use the <code>AccountLog</code> interface instead.
	 */
	public static final String TABLE_NAME = "account_log";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"account_id", Types.BIGINT},
		{"nguoisua_id", Types.BIGINT}, {"ten_nguoisua", Types.VARCHAR},
		{"ngaysua", Types.TIMESTAMP}, {"email_nguoisua", Types.VARCHAR},
		{"phienban", Types.BIGINT}, {"json", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("account_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nguoisua_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ten_nguoisua", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ngaysua", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("email_nguoisua", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phienban", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("json", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table account_log (id LONG not null primary key,account_id LONG,nguoisua_id LONG,ten_nguoisua VARCHAR(75) null,ngaysua DATE null,email_nguoisua VARCHAR(75) null,phienban LONG,json VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table account_log";

	public static final String ORDER_BY_JPQL =
		" ORDER BY accountLog.phienBan DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY account_log.phienban DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.dtt.vn.user.service.model.AccountLog"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.dtt.vn.user.service.model.AccountLog"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.dtt.vn.user.service.model.AccountLog"),
		true);

	public static final long ACCOUNTID_COLUMN_BITMASK = 1L;

	public static final long PHIENBAN_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		dtt.vn.user.service.service.util.ServiceProps.get(
			"lock.expiration.time.dtt.vn.user.service.model.AccountLog"));

	public AccountLogModelImpl() {
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
		return AccountLog.class;
	}

	@Override
	public String getModelClassName() {
		return AccountLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AccountLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AccountLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountLog, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((AccountLog)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AccountLog, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AccountLog, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AccountLog)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AccountLog, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AccountLog, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AccountLog>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AccountLog.class.getClassLoader(), AccountLog.class,
			ModelWrapper.class);

		try {
			Constructor<AccountLog> constructor =
				(Constructor<AccountLog>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AccountLog, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AccountLog, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AccountLog, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AccountLog, Object>>();
		Map<String, BiConsumer<AccountLog, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AccountLog, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object id) {
					accountLog.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"accountId",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getAccountId();
				}

			});
		attributeSetterBiConsumers.put(
			"accountId",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object accountId) {
					accountLog.setAccountId((Long)accountId);
				}

			});
		attributeGetterFunctions.put(
			"nguoiSuaId",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getNguoiSuaId();
				}

			});
		attributeSetterBiConsumers.put(
			"nguoiSuaId",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object nguoiSuaId) {
					accountLog.setNguoiSuaId((Long)nguoiSuaId);
				}

			});
		attributeGetterFunctions.put(
			"tenNguoiSua",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getTenNguoiSua();
				}

			});
		attributeSetterBiConsumers.put(
			"tenNguoiSua",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object tenNguoiSua) {
					accountLog.setTenNguoiSua((String)tenNguoiSua);
				}

			});
		attributeGetterFunctions.put(
			"ngaySua",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getNgaySua();
				}

			});
		attributeSetterBiConsumers.put(
			"ngaySua",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object ngaySua) {
					accountLog.setNgaySua((Date)ngaySua);
				}

			});
		attributeGetterFunctions.put(
			"emailNguoiSua",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getEmailNguoiSua();
				}

			});
		attributeSetterBiConsumers.put(
			"emailNguoiSua",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(
					AccountLog accountLog, Object emailNguoiSua) {

					accountLog.setEmailNguoiSua((String)emailNguoiSua);
				}

			});
		attributeGetterFunctions.put(
			"phienBan",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getPhienBan();
				}

			});
		attributeSetterBiConsumers.put(
			"phienBan",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object phienBan) {
					accountLog.setPhienBan((Long)phienBan);
				}

			});
		attributeGetterFunctions.put(
			"json",
			new Function<AccountLog, Object>() {

				@Override
				public Object apply(AccountLog accountLog) {
					return accountLog.getJson();
				}

			});
		attributeSetterBiConsumers.put(
			"json",
			new BiConsumer<AccountLog, Object>() {

				@Override
				public void accept(AccountLog accountLog, Object json) {
					accountLog.setJson((String)json);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_columnBitmask |= ACCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalAccountId) {
			_setOriginalAccountId = true;

			_originalAccountId = _accountId;
		}

		_accountId = accountId;
	}

	public long getOriginalAccountId() {
		return _originalAccountId;
	}

	@Override
	public long getNguoiSuaId() {
		return _nguoiSuaId;
	}

	@Override
	public void setNguoiSuaId(long nguoiSuaId) {
		_nguoiSuaId = nguoiSuaId;
	}

	@Override
	public String getTenNguoiSua() {
		if (_tenNguoiSua == null) {
			return "";
		}
		else {
			return _tenNguoiSua;
		}
	}

	@Override
	public void setTenNguoiSua(String tenNguoiSua) {
		_tenNguoiSua = tenNguoiSua;
	}

	@Override
	public Date getNgaySua() {
		return _ngaySua;
	}

	@Override
	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	@Override
	public String getEmailNguoiSua() {
		if (_emailNguoiSua == null) {
			return "";
		}
		else {
			return _emailNguoiSua;
		}
	}

	@Override
	public void setEmailNguoiSua(String emailNguoiSua) {
		_emailNguoiSua = emailNguoiSua;
	}

	@Override
	public long getPhienBan() {
		return _phienBan;
	}

	@Override
	public void setPhienBan(long phienBan) {
		_columnBitmask = -1L;

		_phienBan = phienBan;
	}

	@Override
	public String getJson() {
		if (_json == null) {
			return "";
		}
		else {
			return _json;
		}
	}

	@Override
	public void setJson(String json) {
		_json = json;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, AccountLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AccountLog toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AccountLogImpl accountLogImpl = new AccountLogImpl();

		accountLogImpl.setId(getId());
		accountLogImpl.setAccountId(getAccountId());
		accountLogImpl.setNguoiSuaId(getNguoiSuaId());
		accountLogImpl.setTenNguoiSua(getTenNguoiSua());
		accountLogImpl.setNgaySua(getNgaySua());
		accountLogImpl.setEmailNguoiSua(getEmailNguoiSua());
		accountLogImpl.setPhienBan(getPhienBan());
		accountLogImpl.setJson(getJson());

		accountLogImpl.resetOriginalValues();

		return accountLogImpl;
	}

	@Override
	public int compareTo(AccountLog accountLog) {
		int value = 0;

		if (getPhienBan() < accountLog.getPhienBan()) {
			value = -1;
		}
		else if (getPhienBan() > accountLog.getPhienBan()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccountLog)) {
			return false;
		}

		AccountLog accountLog = (AccountLog)obj;

		long primaryKey = accountLog.getPrimaryKey();

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
		AccountLogModelImpl accountLogModelImpl = this;

		accountLogModelImpl._originalAccountId = accountLogModelImpl._accountId;

		accountLogModelImpl._setOriginalAccountId = false;

		accountLogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AccountLog> toCacheModel() {
		AccountLogCacheModel accountLogCacheModel = new AccountLogCacheModel();

		accountLogCacheModel.id = getId();

		accountLogCacheModel.accountId = getAccountId();

		accountLogCacheModel.nguoiSuaId = getNguoiSuaId();

		accountLogCacheModel.tenNguoiSua = getTenNguoiSua();

		String tenNguoiSua = accountLogCacheModel.tenNguoiSua;

		if ((tenNguoiSua != null) && (tenNguoiSua.length() == 0)) {
			accountLogCacheModel.tenNguoiSua = null;
		}

		Date ngaySua = getNgaySua();

		if (ngaySua != null) {
			accountLogCacheModel.ngaySua = ngaySua.getTime();
		}
		else {
			accountLogCacheModel.ngaySua = Long.MIN_VALUE;
		}

		accountLogCacheModel.emailNguoiSua = getEmailNguoiSua();

		String emailNguoiSua = accountLogCacheModel.emailNguoiSua;

		if ((emailNguoiSua != null) && (emailNguoiSua.length() == 0)) {
			accountLogCacheModel.emailNguoiSua = null;
		}

		accountLogCacheModel.phienBan = getPhienBan();

		accountLogCacheModel.json = getJson();

		String json = accountLogCacheModel.json;

		if ((json != null) && (json.length() == 0)) {
			accountLogCacheModel.json = null;
		}

		return accountLogCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AccountLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AccountLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AccountLog)this));
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
		Map<String, Function<AccountLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AccountLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AccountLog)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, AccountLog>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _id;
	private long _accountId;
	private long _originalAccountId;
	private boolean _setOriginalAccountId;
	private long _nguoiSuaId;
	private String _tenNguoiSua;
	private Date _ngaySua;
	private String _emailNguoiSua;
	private long _phienBan;
	private String _json;
	private long _columnBitmask;
	private AccountLog _escapedModel;

}