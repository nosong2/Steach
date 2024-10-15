package com.twentyone.steachserver.domain.studentLecture.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentLecture is a Querydsl query type for StudentLecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentLecture extends EntityPathBase<StudentLecture> {

    private static final long serialVersionUID = -1347814132L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentLecture studentLecture = new QStudentLecture("studentLecture");

    public final com.twentyone.steachserver.domain.common.QBaseTimeEntity _super = new com.twentyone.steachserver.domain.common.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<java.math.BigDecimal> focusRatio = createNumber("focusRatio", java.math.BigDecimal.class);

    public final NumberPath<Integer> focusTime = createNumber("focusTime", Integer.class);

    public final QStudentLectureId id;

    public final com.twentyone.steachserver.domain.lecture.model.QLecture lecture;

    public final NumberPath<Integer> quizAnswerCount = createNumber("quizAnswerCount", Integer.class);

    public final NumberPath<Integer> quizTotalScore = createNumber("quizTotalScore", Integer.class);

    public final com.twentyone.steachserver.domain.member.model.QStudent student;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStudentLecture(String variable) {
        this(StudentLecture.class, forVariable(variable), INITS);
    }

    public QStudentLecture(Path<? extends StudentLecture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudentLecture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudentLecture(PathMetadata metadata, PathInits inits) {
        this(StudentLecture.class, metadata, inits);
    }

    public QStudentLecture(Class<? extends StudentLecture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QStudentLectureId(forProperty("id")) : null;
        this.lecture = inits.isInitialized("lecture") ? new com.twentyone.steachserver.domain.lecture.model.QLecture(forProperty("lecture"), inits.get("lecture")) : null;
        this.student = inits.isInitialized("student") ? new com.twentyone.steachserver.domain.member.model.QStudent(forProperty("student")) : null;
    }

}

