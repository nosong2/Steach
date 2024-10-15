package com.twentyone.steachserver.domain.auth.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLoginCredential is a Querydsl query type for LoginCredential
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLoginCredential extends EntityPathBase<LoginCredential> {

    private static final long serialVersionUID = -622634660L;

    public static final QLoginCredential loginCredential = new QLoginCredential("loginCredential");

    public final com.twentyone.steachserver.domain.common.QBaseTimeEntity _super = new com.twentyone.steachserver.domain.common.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath username = createString("username");

    public QLoginCredential(String variable) {
        super(LoginCredential.class, forVariable(variable));
    }

    public QLoginCredential(Path<? extends LoginCredential> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLoginCredential(PathMetadata metadata) {
        super(LoginCredential.class, metadata);
    }

}

