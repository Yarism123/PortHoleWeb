package com.porthole.porthole.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPortPos is a Querydsl query type for PortPos
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPortPos extends EntityPathBase<PortPos> {

    private static final long serialVersionUID = -214495147L;

    public static final QPortPos portPos = new QPortPos("portPos");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public QPortPos(String variable) {
        super(PortPos.class, forVariable(variable));
    }

    public QPortPos(Path<? extends PortPos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPortPos(PathMetadata metadata) {
        super(PortPos.class, metadata);
    }

}

