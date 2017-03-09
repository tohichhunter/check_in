package in.pleasecome.tohich_hunter.checkin.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Note> notes;
	public static volatile SetAttribute<User, Long> locations;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SetAttribute<User, Conversation> conversations;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Boolean> enabled;
	public static volatile SingularAttribute<User, Long> nativeTown;

}

