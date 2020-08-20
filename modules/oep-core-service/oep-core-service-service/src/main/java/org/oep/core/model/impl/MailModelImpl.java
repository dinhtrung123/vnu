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

package org.oep.core.model.impl;

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

import org.oep.core.model.Mail;
import org.oep.core.model.MailModel;

/**
 * The base model implementation for the Mail service. Represents a row in the &quot;oep_mail_history&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>MailModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MailImpl}.
 * </p>
 *
 * @author manhlb
 * @see MailImpl
 * @generated
 */
@ProviderType
public class MailModelImpl extends BaseModelImpl<Mail> implements MailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a mail model instance should use the <code>Mail</code> interface instead.
	 */
	public static final String TABLE_NAME = "oep_mail_history";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"group_id", Types.BIGINT}, {"ma", Types.VARCHAR},
		{"to_address", Types.VARCHAR}, {"subject", Types.VARCHAR},
		{"body", Types.VARCHAR}, {"ngaygui", Types.TIMESTAMP},
		{"trangthai", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ma", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("to_address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("body", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ngaygui", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("trangthai", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table oep_mail_history (id LONG not null primary key,group_id LONG,ma VARCHAR(75) null,to_address VARCHAR(75) null,subject VARCHAR(75) null,body VARCHAR(75) null,ngaygui DATE null,trangthai BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table oep_mail_history";

	public static final String ORDER_BY_JPQL = " ORDER BY mail.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY oep_mail_history.id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		org.oep.core.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.org.oep.core.model.Mail"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		org.oep.core.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.org.oep.core.model.Mail"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		org.oep.core.service.util.ServiceProps.get(
			"lock.expiration.time.org.oep.core.model.Mail"));

	public MailModelImpl() {
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
		return Mail.class;
	}

	@Override
	public String getModelClassName() {
		return Mail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Mail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Mail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Mail, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Mail)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Mail, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Mail, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Mail)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Mail, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Mail, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Mail>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Mail.class.getClassLoader(), Mail.class, ModelWrapper.class);

		try {
			Constructor<Mail> constructor =
				(Constructor<Mail>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Mail, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Mail, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Mail, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Mail, Object>>();
		Map<String, BiConsumer<Mail, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Mail, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object id) {
					mail.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object groupId) {
					mail.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"code",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getCode();
				}

			});
		attributeSetterBiConsumers.put(
			"code",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object code) {
					mail.setCode((String)code);
				}

			});
		attributeGetterFunctions.put(
			"toAddress",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getToAddress();
				}

			});
		attributeSetterBiConsumers.put(
			"toAddress",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object toAddress) {
					mail.setToAddress((String)toAddress);
				}

			});
		attributeGetterFunctions.put(
			"subject",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getSubject();
				}

			});
		attributeSetterBiConsumers.put(
			"subject",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object subject) {
					mail.setSubject((String)subject);
				}

			});
		attributeGetterFunctions.put(
			"body",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getBody();
				}

			});
		attributeSetterBiConsumers.put(
			"body",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object body) {
					mail.setBody((String)body);
				}

			});
		attributeGetterFunctions.put(
			"ngayGui",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getNgayGui();
				}

			});
		attributeSetterBiConsumers.put(
			"ngayGui",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object ngayGui) {
					mail.setNgayGui((Date)ngayGui);
				}

			});
		attributeGetterFunctions.put(
			"trangThai",
			new Function<Mail, Object>() {

				@Override
				public Object apply(Mail mail) {
					return mail.getTrangThai();
				}

			});
		attributeSetterBiConsumers.put(
			"trangThai",
			new BiConsumer<Mail, Object>() {

				@Override
				public void accept(Mail mail, Object trangThai) {
					mail.setTrangThai((Boolean)trangThai);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_code = code;
	}

	@Override
	public String getToAddress() {
		if (_toAddress == null) {
			return "";
		}
		else {
			return _toAddress;
		}
	}

	@Override
	public void setToAddress(String toAddress) {
		_toAddress = toAddress;
	}

	@Override
	public String getSubject() {
		if (_subject == null) {
			return "";
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@Override
	public String getBody() {
		if (_body == null) {
			return "";
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@Override
	public Date getNgayGui() {
		return _ngayGui;
	}

	@Override
	public void setNgayGui(Date ngayGui) {
		_ngayGui = ngayGui;
	}

	@Override
	public boolean getTrangThai() {
		return _trangThai;
	}

	@Override
	public boolean isTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(boolean trangThai) {
		_trangThai = trangThai;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Mail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Mail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MailImpl mailImpl = new MailImpl();

		mailImpl.setId(getId());
		mailImpl.setGroupId(getGroupId());
		mailImpl.setCode(getCode());
		mailImpl.setToAddress(getToAddress());
		mailImpl.setSubject(getSubject());
		mailImpl.setBody(getBody());
		mailImpl.setNgayGui(getNgayGui());
		mailImpl.setTrangThai(isTrangThai());

		mailImpl.resetOriginalValues();

		return mailImpl;
	}

	@Override
	public int compareTo(Mail mail) {
		long primaryKey = mail.getPrimaryKey();

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

		if (!(obj instanceof Mail)) {
			return false;
		}

		Mail mail = (Mail)obj;

		long primaryKey = mail.getPrimaryKey();

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
	}

	@Override
	public CacheModel<Mail> toCacheModel() {
		MailCacheModel mailCacheModel = new MailCacheModel();

		mailCacheModel.id = getId();

		mailCacheModel.groupId = getGroupId();

		mailCacheModel.code = getCode();

		String code = mailCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			mailCacheModel.code = null;
		}

		mailCacheModel.toAddress = getToAddress();

		String toAddress = mailCacheModel.toAddress;

		if ((toAddress != null) && (toAddress.length() == 0)) {
			mailCacheModel.toAddress = null;
		}

		mailCacheModel.subject = getSubject();

		String subject = mailCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			mailCacheModel.subject = null;
		}

		mailCacheModel.body = getBody();

		String body = mailCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			mailCacheModel.body = null;
		}

		Date ngayGui = getNgayGui();

		if (ngayGui != null) {
			mailCacheModel.ngayGui = ngayGui.getTime();
		}
		else {
			mailCacheModel.ngayGui = Long.MIN_VALUE;
		}

		mailCacheModel.trangThai = isTrangThai();

		return mailCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Mail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Mail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Mail, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Mail)this));
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
		Map<String, Function<Mail, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Mail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Mail, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Mail)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Mail>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _id;
	private long _groupId;
	private String _code;
	private String _toAddress;
	private String _subject;
	private String _body;
	private Date _ngayGui;
	private boolean _trangThai;
	private Mail _escapedModel;

}