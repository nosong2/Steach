package com.twentyone.steachserver.domain.studentCurriculum.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentCurriculumId is a Querydsl query type for StudentCurriculumId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QStudentCurriculumId extends BeanPath<StudentCurriculumId> {

    private static final long serialVersionUID = -1653248883L;

    public static final QStudentCurriculumId studentCurriculumId = new QStudentCurriculumId("studentCurriculumId");

    public final NumberPath<Integer> curriculumId = createNumber("curriculumId", Integer.class);

    public final NumberPath<Integer> studentId = createNumber("studentId", Integer.class);

    public QStudentCurriculumId(String variable) {
        super(StudentCurriculumId.class, forVariable(variable));
    }

    public QStudentCurriculumId(Path<? extends StudentCurriculumId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentCurriculumId(PathMetadata metadata) {
        super(StudentCurriculumId.class, metadata);
    }

}

