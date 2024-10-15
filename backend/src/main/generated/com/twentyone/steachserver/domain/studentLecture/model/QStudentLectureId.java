package com.twentyone.steachserver.domain.studentLecture.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentLectureId is a Querydsl query type for StudentLectureId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QStudentLectureId extends BeanPath<StudentLectureId> {

    private static final long serialVersionUID = 1830744903L;

    public static final QStudentLectureId studentLectureId = new QStudentLectureId("studentLectureId");

    public final NumberPath<Integer> lectureId = createNumber("lectureId", Integer.class);

    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);

    public QStudentLectureId(String variable) {
        super(StudentLectureId.class, forVariable(variable));
    }

    public QStudentLectureId(Path<? extends StudentLectureId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentLectureId(PathMetadata metadata) {
        super(StudentLectureId.class, metadata);
    }

}

