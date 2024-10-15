package com.twentyone.steachserver.domain.curriculum.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCurriculumDetail is a Querydsl query type for CurriculumDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCurriculumDetail extends EntityPathBase<CurriculumDetail> {

    private static final long serialVersionUID = 1168316541L;

    public static final QCurriculumDetail curriculumDetail = new QCurriculumDetail("curriculumDetail");

    public final StringPath bannerImgUrl = createString("bannerImgUrl");

    public final NumberPath<Integer> currentAttendees = createNumber("currentAttendees", Integer.class);

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath information = createString("information");

    public final StringPath intro = createString("intro");

    public final TimePath<java.time.LocalTime> lectureCloseTime = createTime("lectureCloseTime", java.time.LocalTime.class);

    public final TimePath<java.time.LocalTime> lectureStartTime = createTime("lectureStartTime", java.time.LocalTime.class);

    public final NumberPath<Integer> maxAttendees = createNumber("maxAttendees", Integer.class);

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public final StringPath subCategory = createString("subCategory");

    public final StringPath subTitle = createString("subTitle");

    public final NumberPath<Byte> weekdaysBitmask = createNumber("weekdaysBitmask", Byte.class);

    public QCurriculumDetail(String variable) {
        super(CurriculumDetail.class, forVariable(variable));
    }

    public QCurriculumDetail(Path<? extends CurriculumDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCurriculumDetail(PathMetadata metadata) {
        super(CurriculumDetail.class, metadata);
    }

}

