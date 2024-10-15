package com.twentyone.steachserver.domain.curriculum.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCurriculum is a Querydsl query type for Curriculum
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCurriculum extends EntityPathBase<Curriculum> {

    private static final long serialVersionUID = -247001844L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCurriculum curriculum = new QCurriculum("curriculum");

    public final com.twentyone.steachserver.domain.common.QBaseTimeEntity _super = new com.twentyone.steachserver.domain.common.QBaseTimeEntity(this);

    public final EnumPath<com.twentyone.steachserver.domain.curriculum.enums.CurriculumCategory> category = createEnum("category", com.twentyone.steachserver.domain.curriculum.enums.CurriculumCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QCurriculumDetail curriculumDetail;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<com.twentyone.steachserver.domain.lecture.model.Lecture, com.twentyone.steachserver.domain.lecture.model.QLecture> lectures = this.<com.twentyone.steachserver.domain.lecture.model.Lecture, com.twentyone.steachserver.domain.lecture.model.QLecture>createList("lectures", com.twentyone.steachserver.domain.lecture.model.Lecture.class, com.twentyone.steachserver.domain.lecture.model.QLecture.class, PathInits.DIRECT2);

    public final ListPath<com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum, com.twentyone.steachserver.domain.studentCurriculum.model.QStudentCurriculum> studentCurricula = this.<com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum, com.twentyone.steachserver.domain.studentCurriculum.model.QStudentCurriculum>createList("studentCurricula", com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum.class, com.twentyone.steachserver.domain.studentCurriculum.model.QStudentCurriculum.class, PathInits.DIRECT2);

    public final com.twentyone.steachserver.domain.member.model.QTeacher teacher;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCurriculum(String variable) {
        this(Curriculum.class, forVariable(variable), INITS);
    }

    public QCurriculum(Path<? extends Curriculum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCurriculum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCurriculum(PathMetadata metadata, PathInits inits) {
        this(Curriculum.class, metadata, inits);
    }

    public QCurriculum(Class<? extends Curriculum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.curriculumDetail = inits.isInitialized("curriculumDetail") ? new QCurriculumDetail(forProperty("curriculumDetail")) : null;
        this.teacher = inits.isInitialized("teacher") ? new com.twentyone.steachserver.domain.member.model.QTeacher(forProperty("teacher")) : null;
    }

}

