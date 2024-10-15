package com.twentyone.steachserver.domain.auth.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthCode is a Querydsl query type for AuthCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthCode extends EntityPathBase<AuthCode> {

    private static final long serialVersionUID = -205426055L;

    public static final QAuthCode authCode1 = new QAuthCode("authCode1");

    public final StringPath authCode = createString("authCode");

    public final BooleanPath isRegistered = createBoolean("isRegistered");

    public QAuthCode(String variable) {
        super(AuthCode.class, forVariable(variable));
    }

    public QAuthCode(Path<? extends AuthCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthCode(PathMetadata metadata) {
        super(AuthCode.class, metadata);
    }

}

