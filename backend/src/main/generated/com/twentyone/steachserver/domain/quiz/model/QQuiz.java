package com.twentyone.steachserver.domain.quiz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuiz is a Querydsl query type for Quiz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuiz extends EntityPathBase<Quiz> {

    private static final long serialVersionUID = 837593164L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuiz quiz = new QQuiz("quiz");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.twentyone.steachserver.domain.lecture.model.QLecture lecture;

    public final StringPath question = createString("question");

    public final ListPath<QuizChoice, QQuizChoice> quizChoices = this.<QuizChoice, QQuizChoice>createList("quizChoices", QuizChoice.class, QQuizChoice.class, PathInits.DIRECT2);

    public final NumberPath<Integer> quizNumber = createNumber("quizNumber", Integer.class);

    public final ListPath<com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz, com.twentyone.steachserver.domain.studentQuiz.model.QStudentQuiz> studentQuizzes = this.<com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz, com.twentyone.steachserver.domain.studentQuiz.model.QStudentQuiz>createList("studentQuizzes", com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz.class, com.twentyone.steachserver.domain.studentQuiz.model.QStudentQuiz.class, PathInits.DIRECT2);

    public final NumberPath<Integer> time = createNumber("time", Integer.class);

    public QQuiz(String variable) {
        this(Quiz.class, forVariable(variable), INITS);
    }

    public QQuiz(Path<? extends Quiz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuiz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuiz(PathMetadata metadata, PathInits inits) {
        this(Quiz.class, metadata, inits);
    }

    public QQuiz(Class<? extends Quiz> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new com.twentyone.steachserver.domain.lecture.model.QLecture(forProperty("lecture"), inits.get("lecture")) : null;
    }

}

