package in.pleasecome.tohich_hunter.checkin.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conversation.class)
public abstract class Conversation_ {

	public static volatile ListAttribute<Conversation, Long> messages;
	public static volatile SingularAttribute<Conversation, Long> id;
	public static volatile SetAttribute<Conversation, Long> particiants;

}

