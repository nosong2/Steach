package com.twentyone.steachserver.domain.studentQuiz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentQuiz is a Querydsl query type for StudentQuiz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentQuiz extends EntityPathBase<StudentQuiz> {

    private static final long serialVersionUID = 740562374L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentQuiz studentQuiz = new QStudentQuiz("studentQuiz");

    public final QStudentQuizId id;

    public final com.twentyone.steachserver.domain.quiz.model.QQuiz quiz;

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final com.twentyone.steachserver.domain.member.model.QStudent student;

    public final StringPath studentChoice = createString("studentChoice");

    public QStudentQuiz(String variable) {
        this(StudentQuiz.class, forVariable(variable), INITS);
    }

    public QStudentQuiz(Path<? extends StudentQuiz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudentQuiz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudentQuiz(PathMetadata metadata, PathInits inits) {
        this(StudentQuiz.class, metadata, inits);
    }

    public QStudentQuiz(Class<? extends StudentQuiz> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QStudentQuizId(forProperty("id")) : null;
        this.quiz = inits.isInitialized("quiz") ? new com.twentyone.steachserver.domain.quiz.model.QQuiz(forProperty("quiz"), inits.get("quiz")) : null;
        this.student = inits.isInitialized("student") ? new com.twentyone.steachserver.domain.member.model.QStudent(forProperty("student")) : null;
    }

}

