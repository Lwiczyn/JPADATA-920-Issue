package com.example.exists.bug.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.exists.bug.entities.TestEntity.TestEntityPK;

/**
 * An entity with a compound primary key implemented with @IdClass
 */

@Entity
@IdClass(TestEntityPK.class)
public class TestEntity {

	@Id
	private String parent;

	@Id
	private String child;

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestEntity other = (TestEntity) obj;
		if (child == null) {
			if (other.child != null)
				return false;
		} else if (!child.equals(other.child))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WithClassIdEntity [parent=" + parent + ", child=" + child + "]";
	}

	public final static class TestEntityPK implements Serializable {

		private static final long serialVersionUID = 1L;

		private String parent;

		private String child;

		TestEntityPK() {

		}

		public TestEntityPK(String parent, String child) {
			this.parent = parent;
			this.child = child;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((child == null) ? 0 : child.hashCode());
			result = prime * result + ((parent == null) ? 0 : parent.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TestEntityPK other = (TestEntityPK) obj;
			if (child == null) {
				if (other.child != null)
					return false;
			} else if (!child.equals(other.child))
				return false;
			if (parent == null) {
				if (other.parent != null)
					return false;
			} else if (!parent.equals(other.parent))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "WithClassIdEntityPK [parent=" + parent + ", child=" + child + "]";
		}
	}

}
