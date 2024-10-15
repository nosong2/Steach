package com.twentyone.steachserver.domain.studentCurriculum.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentCurriculum is a Querydsl query type for StudentCurriculum
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentCurriculum extends EntityPathBase<StudentCurriculum> {

    private static final long serialVersionUID = -1548087342L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentCurriculum studentCurriculum = new QStudentCurriculum("studentCurriculum");

    public final com.twentyone.steachserver.domain.curriculum.model.QCurriculum curriculum;

    public final QStudentCurriculumId id;

    public final com.twentyone.steachserver.domain.member.model.QStudent student;

    public QStudentCurriculum(String variable) {
        this(StudentCurriculum.class, forVariable(variable), INITS);
    }

    public QStudentCurriculum(Path<? extends StudentCurriculum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudentCurriculum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudentCurriculum(PathMetadata metadata, PathInits inits) {
        this(StudentCurriculum.class, metadata, inits);
    }

    public QStudentCurriculum(Class<? extends StudentCurriculum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.curriculum = inits.isInitialized("curriculum") ? new com.twentyone.steachserver.domain.curriculum.model.QCurriculum(forProperty("curriculum"), inits.get("curriculum")) : null;
        this.id = inits.isInitialized("id") ? new QStudentCurriculumId(forProperty("id")) : null;
        this.student = inits.isInitialized("student") ? new com.twentyone.steachserver.domain.member.model.QStudent(forProperty("student")) : null;
    }

}

