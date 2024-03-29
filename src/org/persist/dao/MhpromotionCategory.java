package org.persist.dao;

// Generated 2013-3-1 15:41:13 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * MhpromotionCategory generated by hbm2java
 */
public class MhpromotionCategory implements java.io.Serializable {

	private String id;
	private String name;
	private Integer online;
	private Integer porder;
	private Set<MhpromotionCategoryRef> mhpromotionCategoryRefs = new HashSet<MhpromotionCategoryRef>(
			0);

	public MhpromotionCategory() {
	}

	public MhpromotionCategory(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public MhpromotionCategory(String id, String name, Integer online,
			Integer porder, Set<MhpromotionCategoryRef> mhpromotionCategoryRefs) {
		this.id = id;
		this.name = name;
		this.online = online;
		this.porder = porder;
		this.mhpromotionCategoryRefs = mhpromotionCategoryRefs;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOnline() {
		return this.online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getPorder() {
		return this.porder;
	}

	public void setPorder(Integer porder) {
		this.porder = porder;
	}

	public Set<MhpromotionCategoryRef> getMhpromotionCategoryRefs() {
		return this.mhpromotionCategoryRefs;
	}

	public void setMhpromotionCategoryRefs(
			Set<MhpromotionCategoryRef> mhpromotionCategoryRefs) {
		this.mhpromotionCategoryRefs = mhpromotionCategoryRefs;
	}

}
