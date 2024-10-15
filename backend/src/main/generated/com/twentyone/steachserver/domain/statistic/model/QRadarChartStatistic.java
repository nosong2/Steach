package com.twentyone.steachserver.domain.statistic.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRadarChartStatistic is a Querydsl query type for RadarChartStatistic
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRadarChartStatistic extends EntityPathBase<RadarChartStatistic> {

    private static final long serialVersionUID = 1055243438L;

    public static final QRadarChartStatistic radarChartStatistic = new QRadarChartStatistic("radarChartStatistic");

    public final NumberPath<java.math.BigDecimal> averageFocusRatio1 = createNumber("averageFocusRatio1", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> averageFocusRatio2 = createNumber("averageFocusRatio2", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> averageFocusRatio3 = createNumber("averageFocusRatio3", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> averageFocusRatio4 = createNumber("averageFocusRatio4", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> averageFocusRatio5 = createNumber("averageFocusRatio5", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> averageFocusRatio6 = createNumber("averageFocusRatio6", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> averageFocusRatio7 = createNumber("averageFocusRatio7", java.math.BigDecimal.class);

    public final StringPath gptCareerSuggestion = createString("gptCareerSuggestion");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Short> lectureCount1 = createNumber("lectureCount1", Short.class);

    public final NumberPath<Short> lectureCount2 = createNumber("lectureCount2", Short.class);

    public final NumberPath<Short> lectureCount3 = createNumber("lectureCount3", Short.class);

    public final NumberPath<Short> lectureCount4 = createNumber("lectureCount4", Short.class);

    public final NumberPath<Short> lectureCount5 = createNumber("lectureCount5", Short.class);

    public final NumberPath<Short> lectureCount6 = createNumber("lectureCount6", Short.class);

    public final NumberPath<Short> lectureCount7 = createNumber("lectureCount7", Short.class);

    public final NumberPath<Integer> sumLectureMinutes1 = createNumber("sumLectureMinutes1", Integer.class);

    public final NumberPath<Integer> sumLectureMinutes2 = createNumber("sumLectureMinutes2", Integer.class);

    public final NumberPath<Integer> sumLectureMinutes3 = createNumber("sumLectureMinutes3", Integer.class);

    public final NumberPath<Integer> sumLectureMinutes4 = createNumber("sumLectureMinutes4", Integer.class);

    public final NumberPath<Integer> sumLectureMinutes5 = createNumber("sumLectureMinutes5", Integer.class);

    public final NumberPath<Integer> sumLectureMinutes6 = createNumber("sumLectureMinutes6", Integer.class);

    public final NumberPath<Integer> sumLectureMinutes7 = createNumber("sumLectureMinutes7", Integer.class);

    public QRadarChartStatistic(String variable) {
        super(RadarChartStatistic.class, forVariable(variable));
    }

    public QRadarChartStatistic(Path<? extends RadarChartStatistic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRadarChartStatistic(PathMetadata metadata) {
        super(RadarChartStatistic.class, metadata);
    }

}

