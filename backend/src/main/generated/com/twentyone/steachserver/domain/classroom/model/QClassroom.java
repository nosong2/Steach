package com.twentyone.steachserver.domain.classroom.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClassroom is a Querydsl query type for Classroom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClassroom extends EntityPathBase<Classroom> {

    private static final long serialVersionUID = 117112268L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClassroom classroom = new QClassroom("classroom");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.twentyone.steachserver.domain.lecture.model.QLecture lecture;

    public final StringPath sessionId = createString("sessionId");

    public QClassroom(String variable) {
        this(Classroom.class, forVariable(variable), INITS);
    }

    public QClassroom(Path<? extends Classroom> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClassroom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClassroom(PathMetadata metadata, PathInits inits) {
        this(Classroom.class, metadata, inits);
    }

    public QClassroom(Class<? extends Classroom> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new com.twentyone.steachserver.domain.lecture.model.QLecture(forProperty("lecture"), inits.get("lecture")) : null;
    }

}

