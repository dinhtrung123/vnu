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

package org.oep.core.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oep.core.exception.NoSuchMailException;
import org.oep.core.model.Mail;
import org.oep.core.model.impl.MailImpl;
import org.oep.core.model.impl.MailModelImpl;
import org.oep.core.service.persistence.MailPersistence;

/**
 * The persistence implementation for the mail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class MailPersistenceImpl
	extends BasePersistenceImpl<Mail> implements MailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MailUtil</code> to access the mail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MailPersistenceImpl() {
		setModelClass(Mail.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("code", "ma");
		dbColumnNames.put("toAddress", "to_address");
		dbColumnNames.put("ngayGui", "ngaygui");
		dbColumnNames.put("trangThai", "trangthai");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the mail in the entity cache if it is enabled.
	 *
	 * @param mail the mail
	 */
	@Override
	public void cacheResult(Mail mail) {
		entityCache.putResult(
			MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
			mail.getPrimaryKey(), mail);

		mail.resetOriginalValues();
	}

	/**
	 * Caches the mails in the entity cache if it is enabled.
	 *
	 * @param mails the mails
	 */
	@Override
	public void cacheResult(List<Mail> mails) {
		for (Mail mail : mails) {
			if (entityCache.getResult(
					MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
					mail.getPrimaryKey()) == null) {

				cacheResult(mail);
			}
			else {
				mail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mails.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Mail mail) {
		entityCache.removeResult(
			MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
			mail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Mail> mails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Mail mail : mails) {
			entityCache.removeResult(
				MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
				mail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mail with the primary key. Does not add the mail to the database.
	 *
	 * @param id the primary key for the new mail
	 * @return the new mail
	 */
	@Override
	public Mail create(long id) {
		Mail mail = new MailImpl();

		mail.setNew(true);
		mail.setPrimaryKey(id);

		return mail;
	}

	/**
	 * Removes the mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mail
	 * @return the mail that was removed
	 * @throws NoSuchMailException if a mail with the primary key could not be found
	 */
	@Override
	public Mail remove(long id) throws NoSuchMailException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mail
	 * @return the mail that was removed
	 * @throws NoSuchMailException if a mail with the primary key could not be found
	 */
	@Override
	public Mail remove(Serializable primaryKey) throws NoSuchMailException {
		Session session = null;

		try {
			session = openSession();

			Mail mail = (Mail)session.get(MailImpl.class, primaryKey);

			if (mail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mail);
		}
		catch (NoSuchMailException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Mail removeImpl(Mail mail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mail)) {
				mail = (Mail)session.get(
					MailImpl.class, mail.getPrimaryKeyObj());
			}

			if (mail != null) {
				session.delete(mail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mail != null) {
			clearCache(mail);
		}

		return mail;
	}

	@Override
	public Mail updateImpl(Mail mail) {
		boolean isNew = mail.isNew();

		Session session = null;

		try {
			session = openSession();

			if (mail.isNew()) {
				session.save(mail);

				mail.setNew(false);
			}
			else {
				mail = (Mail)session.merge(mail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
			mail.getPrimaryKey(), mail, false);

		mail.resetOriginalValues();

		return mail;
	}

	/**
	 * Returns the mail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mail
	 * @return the mail
	 * @throws NoSuchMailException if a mail with the primary key could not be found
	 */
	@Override
	public Mail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMailException {

		Mail mail = fetchByPrimaryKey(primaryKey);

		if (mail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mail;
	}

	/**
	 * Returns the mail with the primary key or throws a <code>NoSuchMailException</code> if it could not be found.
	 *
	 * @param id the primary key of the mail
	 * @return the mail
	 * @throws NoSuchMailException if a mail with the primary key could not be found
	 */
	@Override
	public Mail findByPrimaryKey(long id) throws NoSuchMailException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mail
	 * @return the mail, or <code>null</code> if a mail with the primary key could not be found
	 */
	@Override
	public Mail fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Mail mail = (Mail)serializable;

		if (mail == null) {
			Session session = null;

			try {
				session = openSession();

				mail = (Mail)session.get(MailImpl.class, primaryKey);

				if (mail != null) {
					cacheResult(mail);
				}
				else {
					entityCache.putResult(
						MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mail;
	}

	/**
	 * Returns the mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the mail
	 * @return the mail, or <code>null</code> if a mail with the primary key could not be found
	 */
	@Override
	public Mail fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Mail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Mail> map = new HashMap<Serializable, Mail>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Mail mail = fetchByPrimaryKey(primaryKey);

			if (mail != null) {
				map.put(primaryKey, mail);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Mail)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_MAIL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Mail mail : (List<Mail>)q.list()) {
				map.put(mail.getPrimaryKeyObj(), mail);

				cacheResult(mail);

				uncachedPrimaryKeys.remove(mail.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					MailModelImpl.ENTITY_CACHE_ENABLED, MailImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the mails.
	 *
	 * @return the mails
	 */
	@Override
	public List<Mail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @return the range of mails
	 */
	@Override
	public List<Mail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mails
	 */
	@Override
	public List<Mail> findAll(
		int start, int end, OrderByComparator<Mail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of mails
	 */
	@Override
	public List<Mail> findAll(
		int start, int end, OrderByComparator<Mail> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Mail> list = null;

		if (retrieveFromCache) {
			list = (List<Mail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MAIL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAIL;

				if (pagination) {
					sql = sql.concat(MailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Mail>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Mail>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the mails from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Mail mail : findAll()) {
			remove(mail);
		}
	}

	/**
	 * Returns the number of mails.
	 *
	 * @return the number of mails
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MAIL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mail persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			MailModelImpl.ENTITY_CACHE_ENABLED,
			MailModelImpl.FINDER_CACHE_ENABLED, MailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			MailModelImpl.ENTITY_CACHE_ENABLED,
			MailModelImpl.FINDER_CACHE_ENABLED, MailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			MailModelImpl.ENTITY_CACHE_ENABLED,
			MailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(MailImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MAIL = "SELECT mail FROM Mail mail";

	private static final String _SQL_SELECT_MAIL_WHERE_PKS_IN =
		"SELECT mail FROM Mail mail WHERE id IN (";

	private static final String _SQL_COUNT_MAIL =
		"SELECT COUNT(mail) FROM Mail mail";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Mail exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"groupId", "code", "toAddress", "ngayGui", "trangThai"});

}