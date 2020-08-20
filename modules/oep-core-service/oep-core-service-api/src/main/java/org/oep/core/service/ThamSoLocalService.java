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

package org.oep.core.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.oep.core.model.ThamSo;

/**
 * Provides the local service interface for ThamSo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author manhlb
 * @see ThamSoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ThamSoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThamSoLocalServiceUtil} to access the tham so local service. Add custom service methods to <code>org.oep.core.service.impl.ThamSoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public ThamSo addThamSo(
			Long groupId, Long loaiThamSoId, String ma, String giaTri,
			String moTa, boolean statusActive, int quyen)
		throws Exception;

	/**
	 * Adds the tham so to the database. Also notifies the appropriate model listeners.
	 *
	 * @param thamSo the tham so
	 * @return the tham so that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ThamSo addThamSo(ThamSo thamSo);

	/**
	 * count match tham so by to chuc id - loai tham so id - ma
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create new
	 *
	 * @param groupId						groupId
	 loaiThamSoId				loai tham so id
	 ma							ma
	 * @return: int							number of match data
	 * @throws SystemException
	 */
	public int countByL_M(long groupId, long loaiThamSoId, String ma);

	/**
	 * Creates a new tham so with the primary key. Does not add the tham so to the database.
	 *
	 * @param id the primary key for the new tham so
	 * @return the new tham so
	 */
	@Transactional(enabled = false)
	public ThamSo createThamSo(long id);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws PortalException if a tham so with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ThamSo deleteThamSo(long id) throws PortalException;

	/**
	 * Deletes the tham so from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thamSo the tham so
	 * @return the tham so that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ThamSo deleteThamSo(ThamSo thamSo);

	public ThamSo deleteThamSolong(long id)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ThamSo fetchThamSo(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ThamSo> getAll() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ThamSo> getByMa(String ma) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ThamSo> getByValue(String value) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the tham so with the primary key.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so
	 * @throws PortalException if a tham so with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ThamSo getThamSo(long id) throws PortalException;

	/**
	 * Returns a range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of tham sos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ThamSo> getThamSos(int start, int end);

	/**
	 * Returns the number of tham sos.
	 *
	 * @return the number of tham sos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getThamSosCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ThamSo getValue(long groupId, String ma);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getValue(long groupId, String ma, String defaultValue);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ThamSo getValue(String className, long classPK, String ma);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getValue(
		String className, long classPK, String ma, String defaultValue);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getValue(String ma, String defaultValue);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getValue(
		String ma, String className, long classPK, String defaultValue);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getValue(String ma, String className, String defaultValue);

	/**
	 * get gia tri tham so by ma
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create new
	 *
	 * @param context					service context
	 mas						finding mas
	 * @return: Map<String, String>		mapping ma - gia tri
	 * @throws SystemException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, String> getValues(long groupId, List<String> mas);

	public ThamSo save(
		Long groupId, String className, long classPK, String ma, String giaTri,
		String moTa, long loaiThamSoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ThamSo> searchByL_M(
		long groupId, long loaiId, String ma, int start, int end);

	/**
	 * handle change status tham so
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create
	 *
	 * @param context						service context
	 id							id
	 * @return:
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IllegalAccessException
	 */
	public ThamSo thayDoiTrangThaiThamSo(long id) throws Exception;

	/**
	 * handle update tham so
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create new
	 *
	 * @param context						service context
	 loaiThamSoId					loai tham so
	 ma							ma
	 giaTri						gia tri
	 moTo							mo ta
	 * @return:
	 * @throws SystemException
	 * @throws PortalException
	 * @throws Exception
	 */
	public ThamSo updateThamSo(
			long id, long loaiThamSoId, String ma, String giaTri, String moTa,
			boolean status)
		throws SystemException;

	/**
	 * Updates the tham so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param thamSo the tham so
	 * @return the tham so that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ThamSo updateThamSo(ThamSo thamSo);

}