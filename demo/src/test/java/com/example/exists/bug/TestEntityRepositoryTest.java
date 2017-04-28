package com.example.exists.bug;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exists.bug.repository.TestEntityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
public class TestEntityRepositoryTest {

	@Autowired
	private TestEntityRepository testEntityRepository;

	/**
	 * <p>
	 * Application fails to load due to a {@link NullPointerException} thrown at
	 * <ul>
	 * <li>
	 * org.hibernate.jpa.criteria.path.AbstractPathImpl.get(AbstractPathImpl.
	 * java:123) ~[hibernate-entitymanager-5.0.12.Final.jar:5.0.12.Final]</li>
	 * <li>
	 * org.springframework.data.jpa.repository.query.JpaQueryCreator.complete(
	 * JpaQueryCreator.java:187) ~[spring-data-jpa-1.11.3.RELEASE.jar:na]</li>
	 * </ul>
	 * </p>
	 * <p>
	 * {@link AbstractPersistable_#id} is null at this location when it should
	 * have a value.
	 * </p>
	 * 
	 * <p>
	 * **NOTE** As the point of this test is to demonstrate the application
	 * fails to load, no actual assertions were added.
	 * </p>
	 * 
	 * @see <a href="https://jira.spring.io/browse/DATAJPA-920">DATAJPA-920</a>
	 * 
	 * @see <a href=
	 *      "https://github.com/spring-projects/spring-data-jpa/search?q=DATAJPA
	 *      -920&type=Commits&utf8=%E2%9C%93">Github commits</a>
	 */
	@Test
	public void existsByParentCausesApplicationSetupToFailWithNullPointerException() {
		testEntityRepository.existsByParent("parent");
	}

}
