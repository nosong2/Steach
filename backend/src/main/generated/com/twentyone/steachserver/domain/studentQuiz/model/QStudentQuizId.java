package com.twentyone.steachserver.domain.studentQuiz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentQuizId is a Querydsl query type for StudentQuizId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QStudentQuizId extends BeanPath<StudentQuizId> {

    private static final long serialVersionUID = -1284127359L;

    public static final QStudentQuizId studentQuizId = new QStudentQuizId("studentQuizId");

    public final NumberPath<Integer> quizId = createNumber("quizId", Integer.class);

    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);

    public QStudentQuizId(String variable) {
        super(StudentQuizId.class, forVariable(variable));
    }

    public QStudentQuizId(Path<? extends StudentQuizId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentQuizId(PathMetadata metadata) {
        super(StudentQuizId.class, metadata);
    }

}

