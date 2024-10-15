package com.twentyone.steachserver.domain.member.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeacher is a Querydsl query type for Teacher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeacher extends EntityPathBase<Teacher> {

    private static final long serialVersionUID = 463993936L;

    public static final QTeacher teacher = new QTeacher("teacher");

    public final com.twentyone.steachserver.domain.auth.model.QLoginCredential _super = new com.twentyone.steachserver.domain.auth.model.QLoginCredential(this);

    public final StringPath academicBackground = createString("academicBackground");

    public final StringPath briefIntroduction = createString("briefIntroduction");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<com.twentyone.steachserver.domain.curriculum.model.Curriculum, com.twentyone.steachserver.domain.curriculum.model.QCurriculum> curriculumList = this.<com.twentyone.steachserver.domain.curriculum.model.Curriculum, com.twentyone.steachserver.domain.curriculum.model.QCurriculum>createList("curriculumList", com.twentyone.steachserver.domain.curriculum.model.Curriculum.class, com.twentyone.steachserver.domain.curriculum.model.QCurriculum.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath password = _super.password;

    public final StringPath pathQualification = createString("pathQualification");

    public final StringPath specialization = createString("specialization");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath username = _super.username;

    public final NumberPath<Integer> volunteerTime = createNumber("volunteerTime", Integer.class);

    public QTeacher(String variable) {
        super(Teacher.class, forVariable(variable));
    }

    public QTeacher(Path<? extends Teacher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeacher(PathMetadata metadata) {
        super(Teacher.class, metadata);
    }

}

