package in.pleasecome.tohich_hunter.checkin.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Note.class)
public abstract class Note_ {

	public static volatile SingularAttribute<Note, String> name;
	public static volatile SingularAttribute<Note, Long> location;
	public static volatile SingularAttribute<Note, Long> id;
	public static volatile SingularAttribute<Note, String> text;
	public static volatile SetAttribute<Note, String> photos;
	public static volatile SingularAttribute<Note, Long> user;

}

