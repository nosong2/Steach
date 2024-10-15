package com.twentyone.steachserver.domain.lecture.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLecture is a Querydsl query type for Lecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLecture extends EntityPathBase<Lecture> {

    private static final long serialVersionUID = 1740540258L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLecture lecture = new QLecture("lecture");

    public final com.twentyone.steachserver.domain.curriculum.model.QCurriculum curriculum;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> lectureEndDate = createDateTime("lectureEndDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> lectureOrder = createNumber("lectureOrder", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> lectureStartDate = createDateTime("lectureStartDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> numberOfQuizzes = createNumber("numberOfQuizzes", Integer.class);

    public final ListPath<com.twentyone.steachserver.domain.quiz.model.Quiz, com.twentyone.steachserver.domain.quiz.model.QQuiz> quizzes = this.<com.twentyone.steachserver.domain.quiz.model.Quiz, com.twentyone.steachserver.domain.quiz.model.QQuiz>createList("quizzes", com.twentyone.steachserver.domain.quiz.model.Quiz.class, com.twentyone.steachserver.domain.quiz.model.QQuiz.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> realEndTime = createDateTime("realEndTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> realStartTime = createDateTime("realStartTime", java.time.LocalDateTime.class);

    public final ListPath<com.twentyone.steachserver.domain.studentLecture.model.StudentLecture, com.twentyone.steachserver.domain.studentLecture.model.QStudentLecture> studentLectures = this.<com.twentyone.steachserver.domain.studentLecture.model.StudentLecture, com.twentyone.steachserver.domain.studentLecture.model.QStudentLecture>createList("studentLectures", com.twentyone.steachserver.domain.studentLecture.model.StudentLecture.class, com.twentyone.steachserver.domain.studentLecture.model.QStudentLecture.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QLecture(String variable) {
        this(Lecture.class, forVariable(variable), INITS);
    }

    public QLecture(Path<? extends Lecture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLecture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLecture(PathMetadata metadata, PathInits inits) {
        this(Lecture.class, metadata, inits);
    }

    public QLecture(Class<? extends Lecture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.curriculum = inits.isInitialized("curriculum") ? new com.twentyone.steachserver.domain.curriculum.model.QCurriculum(forProperty("curriculum"), inits.get("curriculum")) : null;
    }

}

