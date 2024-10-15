package com.twentyone.steachserver.domain.member.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 24425129L;

    public static final QStudent student = new QStudent("student");

    public final com.twentyone.steachserver.domain.auth.model.QLoginCredential _super = new com.twentyone.steachserver.domain.auth.model.QLoginCredential(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath password = _super.password;

    public final ListPath<com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum, com.twentyone.steachserver.domain.studentCurriculum.model.QStudentCurriculum> studentCurricula = this.<com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum, com.twentyone.steachserver.domain.studentCurriculum.model.QStudentCurriculum>createList("studentCurricula", com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum.class, com.twentyone.steachserver.domain.studentCurriculum.model.QStudentCurriculum.class, PathInits.DIRECT2);

    public final ListPath<com.twentyone.steachserver.domain.studentLecture.model.StudentLecture, com.twentyone.steachserver.domain.studentLecture.model.QStudentLecture> studentLectures = this.<com.twentyone.steachserver.domain.studentLecture.model.StudentLecture, com.twentyone.steachserver.domain.studentLecture.model.QStudentLecture>createList("studentLectures", com.twentyone.steachserver.domain.studentLecture.model.StudentLecture.class, com.twentyone.steachserver.domain.studentLecture.model.QStudentLecture.class, PathInits.DIRECT2);

    public final ListPath<com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz, com.twentyone.steachserver.domain.studentQuiz.model.QStudentQuiz> studentQuizzes = this.<com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz, com.twentyone.steachserver.domain.studentQuiz.model.QStudentQuiz>createList("studentQuizzes", com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz.class, com.twentyone.steachserver.domain.studentQuiz.model.QStudentQuiz.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath username = _super.username;

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

