package com.twentyone.steachserver.domain.quiz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuizStatistics is a Querydsl query type for QuizStatistics
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuizStatistics extends EntityPathBase<QuizStatistics> {

    private static final long serialVersionUID = 1968064143L;

    public static final QQuizStatistics quizStatistics = new QQuizStatistics("quizStatistics");

    public final NumberPath<Integer> currentRank = createNumber("currentRank", Integer.class);

    public final NumberPath<Integer> currentScore = createNumber("currentScore", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> lectureId = createNumber("lectureId", Integer.class);

    public final NumberPath<Integer> prevRank = createNumber("prevRank", Integer.class);

    public final NumberPath<Integer> prevScore = createNumber("prevScore", Integer.class);

    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);

    public QQuizStatistics(String variable) {
        super(QuizStatistics.class, forVariable(variable));
    }

    public QQuizStatistics(Path<? extends QuizStatistics> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuizStatistics(PathMetadata metadata) {
        super(QuizStatistics.class, metadata);
    }

}

