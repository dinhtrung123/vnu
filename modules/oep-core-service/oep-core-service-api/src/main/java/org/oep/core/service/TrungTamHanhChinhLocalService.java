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

import org.oep.core.model.TrungTamHanhChinh;

/**
 * Provides the local service interface for TrungTamHanhChinh. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author manhlb
 * @see TrungTamHanhChinhLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TrungTamHanhChinhLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrungTamHanhChinhLocalServiceUtil} to access the trung tam hanh chinh local service. Add custom service methods to <code>org.oep.core.service.impl.TrungTamHanhChinhLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addOrUpdate(
			long id, long coQuanQuanLyId, String ten, String ma,
			String donVi_Ids, int trangThai, String thongTinLienHe)
		throws SystemException;

	/**
	 * Adds the trung tam hanh chinh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TrungTamHanhChinh addTrungTamHanhChinh(
		TrungTamHanhChinh trungTamHanhChinh);

	public int countTTHC(String ten_ma, long coQuanQuanLyId, int trangThai);

	/**
	 * Creates a new trung tam hanh chinh with the primary key. Does not add the trung tam hanh chinh to the database.
	 *
	 * @param id the primary key for the new trung tam hanh chinh
	 * @return the new trung tam hanh chinh
	 */
	@Transactional(enabled = false)
	public TrungTamHanhChinh createTrungTamHanhChinh(long id);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws PortalException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TrungTamHanhChinh deleteTrungTamHanhChinh(long id)
		throws PortalException;

	/**
	 * Deletes the trung tam hanh chinh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TrungTamHanhChinh deleteTrungTamHanhChinh(
		TrungTamHanhChinh trungTamHanhChinh);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public TrungTamHanhChinh fetchTrungTamHanhChinh(long id);

	public TrungTamHanhChinh findByDonViXuLyId(long donvixulyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrungTamHanhChinh getByCoQuanQuanLyId(long coQuanQuanLyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrungTamHanhChinh getByMa(String ma) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDonViXuLyIds(long trungTamHanhChinhId);

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
	 * Returns the trung tam hanh chinh with the primary key.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws PortalException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrungTamHanhChinh getTrungTamHanhChinh(long id)
		throws PortalException;

	/**
	 * Returns a range of all the trung tam hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trung tam hanh chinhs
	 * @param end the upper bound of the range of trung tam hanh chinhs (not inclusive)
	 * @return the range of trung tam hanh chinhs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrungTamHanhChinh> getTrungTamHanhChinhs(int start, int end);

	/**
	 * Returns the number of trung tam hanh chinhs.
	 *
	 * @return the number of trung tam hanh chinhs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTrungTamHanhChinhsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrungTamHanhChinh> searchByTen_Ma_CQQL(
		String ten_ma, long coQuanQuanLyId, int trangThai, int start, int end);

	/**
	 * Updates the trung tam hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TrungTamHanhChinh updateTrungTamHanhChinh(
		TrungTamHanhChinh trungTamHanhChinh);

}