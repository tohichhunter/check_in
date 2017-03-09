package in.pleasecome.tohich_hunter.checkin.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Message.class)
public abstract class Message_ {

	public static volatile SingularAttribute<Message, User> sender;
	public static volatile SingularAttribute<Message, Long> conversationId;
	public static volatile SingularAttribute<Message, Long> id;
	public static volatile SingularAttribute<Message, String> text;
	public static volatile SingularAttribute<Message, Long> time;

}

