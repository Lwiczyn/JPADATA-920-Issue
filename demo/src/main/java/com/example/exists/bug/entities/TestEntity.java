package com.example.exists.bug.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.exists.bug.entities.TestEntity.TestEntityPK;

@Entity
@IdClass(TestEntityPK.class)
public class TestEntity {

	@Id
	private String parent;

	@Id
	private String child;

	private boolean isIdField = false; // Other non-id field to more accurately
										// reproduce the class that was throwing
										// this error for me

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

	public boolean isIdField() {
		return isIdField;
	}

	public void setIdField(boolean isIdField) {
		this.isIdField = isIdField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		result = prime * result + (isIdField ? 1231 : 1237);
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
		if (isIdField != other.isIdField)
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
		return "WithClassIdEntity [parent=" + parent + ", child=" + child + ", isIdField=" + isIdField + "]";
	}

	protected final static class TestEntityPK implements Serializable {

		private static final long serialVersionUID = 2220558299636114016L;

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
